package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.service.ServiceInterface.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceIMPL implements GroupService {
    @Override
    public void addGroup(Group group) {

    }

    @Override
    public Group getGroup(UUID uuid) {
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return null;
    }

    @Override
    public void updateGroup(Group group) {

    }

    @Override
    public void removeGroup(UUID uuid) {

    }
}
