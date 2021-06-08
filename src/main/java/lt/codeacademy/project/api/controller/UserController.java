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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(EndPoint.API_ROOT_USER_CONTROLLER)
@Api
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final UserDto userDto;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userDto = new UserDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all Users", httpMethod = "GET")
    public List<UserDto> getUsers() {
        return userDto.parseList(userService.getAllUsers());
    }

    @GetMapping(value = EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get User by UUID", httpMethod = "GET")
    private UserDto getUser(@PathVariable(EndPoint.UUID) UUID uuid) {
        return userDto.parseObject(userService.getUser(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create User", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user) {
        user.setRoles(Set.of(roleService.findByName("USER")));
        userService.addUser(user);
    }

    @DeleteMapping(value = EndPoint.BY_UUID)
    @ApiOperation(value = "Remove User", httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable(EndPoint.UUID) UUID uuid) {
        userService.removeUser(uuid);
    }

    @PutMapping
    @ApiOperation(value = "Update User", httpMethod = "PUT")
    public UserDto updateProduct(@Valid @RequestBody User user) {
        user.setRoles(userService.getUser(user.getId()).getRoles());
        return userDto.parseObject(userService.updateUser(user));
    }

}
