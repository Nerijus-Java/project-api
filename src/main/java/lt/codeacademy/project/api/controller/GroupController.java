package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(EndPoint.API_ROOT_GROUP_CONTROLLER)
@Api
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all groups", httpMethod = "GET")
    public List<Group> GetGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping(value = EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Group by UUID", httpMethod = "GET")
    private Group getGroup(@PathVariable(EndPoint.UUID) UUID uuid) {
        return groupService.getGroup(uuid);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Group", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@Valid @RequestBody Group group) {
        //TODO set user to group

        //        group.setUser();
        groupService.addGroup(group);
    }

    @DeleteMapping(value = EndPoint.BY_UUID)
    @ApiOperation(value = "Remove Group", httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable(EndPoint.UUID) UUID uuid) {
        groupService.removeGroup(uuid);
    }

    @PutMapping
    @ApiOperation(value = "Update Group", httpMethod = "PUT")
    public Group updateGroup(@Valid @RequestBody Group group) {
        return groupService.updateGroup(group);
    }
}
