package lt.codeacademy.project.api.service.ServiceInterface;

import lt.codeacademy.project.api.entity.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {

    void addGroup(Group group);

    Group getGroup(UUID uuid);

    List<Group> getAllGroups();

    void updateGroup(Group group);

    void removeGroup(UUID uuid);
}
