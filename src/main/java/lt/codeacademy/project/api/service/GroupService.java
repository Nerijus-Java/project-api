package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.Group;
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

    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    public Group getGroup(UUID uuid) {
        return groupRepository.getById(uuid);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    public void removeGroup(UUID uuid) {
        groupRepository.deleteById(uuid);
    }
}
