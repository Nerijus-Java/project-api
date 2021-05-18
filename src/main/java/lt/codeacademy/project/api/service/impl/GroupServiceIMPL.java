package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.repository.GroupRepository;
import lt.codeacademy.project.api.service.ServiceInterface.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceIMPL implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceIMPL(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Group getGroup(UUID uuid) {
        return groupRepository.getById(uuid);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void updateGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void removeGroup(UUID uuid) {
        groupRepository.deleteById(uuid);
    }
}
