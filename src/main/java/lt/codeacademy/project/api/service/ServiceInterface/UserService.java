package lt.codeacademy.project.api.service.ServiceInterface;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void addUser(User user);

    Group getUser(UUID uuid);

    List<Post> getAllUsers();

    void updateUser(User user);

    void removeUser(UUID uuid);
}
