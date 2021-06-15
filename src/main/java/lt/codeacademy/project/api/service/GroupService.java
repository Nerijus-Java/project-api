package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.exception.GroupNotFoundException;
import lt.codeacademy.project.api.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserService userService;

    public GroupService(GroupRepository groupRepository, UserService userService) {
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group getGroup(UUID uuid) {
        return groupRepository.findById(uuid).orElseThrow(() -> new GroupNotFoundException("Group does not exist"));
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getGroupsUserFollows(UUID uuid) {
        return groupRepository.findAll().stream()
                .filter(e -> e.getFollowers().contains(userService.getUser(uuid))).collect(Collectors.toList());
    }

    public void unFollowUser(User user, UUID groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group does not exist"));
        group.setFollowers(group.getFollowers().stream().filter(e -> !e.getId().equals(user.getId())).collect(Collectors.toSet()));
        groupRepository.save(group);
    }

    public void removeGroup(UUID uuid) {
        groupRepository.deleteById(uuid);
    }
}
