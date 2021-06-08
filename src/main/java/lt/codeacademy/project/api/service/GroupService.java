package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.exception.GroupNotFoundException;
import lt.codeacademy.project.api.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
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

    public void removeGroup(UUID uuid) {
        groupRepository.deleteById(uuid);
    }
}
