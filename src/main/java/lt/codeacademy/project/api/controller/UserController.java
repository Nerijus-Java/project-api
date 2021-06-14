package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.dto.UserDto;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.service.RoleService;
import lt.codeacademy.project.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(EndPoint.API_ROOT)
@Api
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final UserDto userDto;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userDto = new UserDto();
    }

    @GetMapping(value = EndPoint.PUBLIC + EndPoint.USER,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all Users", httpMethod = "GET")
    public List<UserDto> getUsers() {
        return userDto.parseList(userService.getAllUsers());
    }

    @GetMapping(value = EndPoint.PUBLIC + EndPoint.USER+ EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get User by UUID", httpMethod = "GET")
    private UserDto getUser(@PathVariable(EndPoint.UUID) UUID uuid) {
        return userDto.parseObject(userService.getUser(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = EndPoint.PUBLIC + EndPoint.USER)
    @ApiOperation(value = "Create User", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user) {
        user.setRoles(Set.of(roleService.findByName("USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBio("New User");
        userService.addUser(user);
    }

    @DeleteMapping(value =EndPoint.USER + EndPoint.BY_UUID)
    @ApiOperation(value = "Remove User", httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(EndPoint.UUID) UUID uuid) {
        userService.removeUser(uuid);
    }
}
