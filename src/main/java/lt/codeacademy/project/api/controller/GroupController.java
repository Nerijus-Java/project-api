package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.dto.GroupDto;
import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.exception.GroupNotFoundException;
import lt.codeacademy.project.api.service.GroupService;
import lt.codeacademy.project.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(EndPoint.API_ROOT)
@Api
public class GroupController {

    private final GroupService groupService;
    private final UserService userService;
    private final GroupDto groupDto;

    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
        this.groupDto = new GroupDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = EndPoint.PUBLIC + EndPoint.GROUP)
    @ApiOperation(value = "Get all groups", httpMethod = "GET")
    public List<GroupDto> GetGroups() {
        return groupDto.parseList(groupService.getAllGroups());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = EndPoint.GROUP + EndPoint.BY_UUID + EndPoint.USER)
    @ApiOperation(value = "Get all groups by user id", httpMethod = "GET")
    public List<GroupDto> GetGroupsByUserId(@PathVariable(EndPoint.UUID) UUID uuid) {
        return groupDto.parseList(userService.getUser(uuid).getGroups());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = EndPoint.GROUP + EndPoint.FOLLOWER + EndPoint.BY_UUID + EndPoint.USER)
    @ApiOperation(value = "Get all groups by user id Following", httpMethod = "GET")
    public List<GroupDto> GetGroupsFollowByUserId(@PathVariable(EndPoint.UUID) UUID uuid) {
        return groupDto.parseList(groupService.getGroupsUserFollows(uuid));
    }

    @GetMapping(value = EndPoint.PUBLIC + EndPoint.GROUP + EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Group by UUID", httpMethod = "GET")
    private GroupDto getGroup(@PathVariable(EndPoint.UUID) UUID uuid) {
        return groupDto.parseObject(groupService.getGroup(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , value = EndPoint.GROUP)
    @ApiOperation(value = "Create Group", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDto createGroup(@Valid @RequestBody Group group, @AuthenticationPrincipal String username) {
        group.setUser((User) userService.loadUserByUsername(username));
        return groupDto.parseObject(groupService.addGroup(group));
    }

    @DeleteMapping(value = EndPoint.GROUP + EndPoint.BY_UUID)
    @ApiOperation(value = "Remove Group", httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable(EndPoint.UUID) UUID uuid) {
        groupService.removeGroup(uuid);
    }

    @PutMapping(EndPoint.GROUP)
    @ApiOperation(value = "Update Group", httpMethod = "PUT")
    public GroupDto updateGroup(@Valid @RequestBody Group group, @AuthenticationPrincipal String username) {
        Group groupUpdating = groupService.getGroup(group.getId());
        User loggedInUser = (User) userService.loadUserByUsername(username);
        if (username.equals(groupUpdating.getUser().getUsername()) || loggedInUser.getRoles().contains("ROLE_ADMIN")){
            group.setFollowers(groupUpdating.getFollowers());
            group.setPosts(groupUpdating.getPosts());
            group.setUser(groupUpdating.getUser());
            return groupDto.parseObject(groupService.updateGroup(group));
        } else {
            throw new GroupNotFoundException("NO!");
        }
    }
}
