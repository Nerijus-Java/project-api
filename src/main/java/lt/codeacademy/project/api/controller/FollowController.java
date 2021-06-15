package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.service.GroupService;
import lt.codeacademy.project.api.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(EndPoint.API_ROOT)
@Api
public class FollowController {

    private final GroupService groupService;

    private final UserService userService;

    public FollowController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @PostMapping(value = EndPoint.FOLLOWER + EndPoint.BY_UUID)
    @ApiOperation(value = "Follow Group", httpMethod = "POST")
    public void followGroup(@PathVariable(EndPoint.UUID) UUID uuid, @AuthenticationPrincipal String username) {
        Group group = groupService.getGroup(uuid);
        group.getFollowers().add((User) userService.loadUserByUsername(username));
        groupService.updateGroup(group);
    }

    @DeleteMapping(value = EndPoint.FOLLOWER + EndPoint.BY_UUID)
    @ApiOperation(value = "unFollow Group", httpMethod = "DELETE")
    public void unFollowGroup(@PathVariable(EndPoint.UUID) UUID uuid, @AuthenticationPrincipal String username) {
        groupService.unFollowUser((User) userService.loadUserByUsername(username), uuid);
    }

    @GetMapping(value = EndPoint.FOLLOWER + EndPoint.BY_UUID)
    @ApiOperation(value = "unFollow Group", httpMethod = "GET")
    public boolean isFollowGroup(@PathVariable(EndPoint.UUID) UUID uuid, @AuthenticationPrincipal String username) {
        return groupService.getGroup(uuid).getFollowers().contains((User) userService.loadUserByUsername(username));
    }

}
