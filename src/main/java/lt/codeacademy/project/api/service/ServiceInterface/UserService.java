package lt.codeacademy.project.api.service.ServiceInterface;

import lt.codeacademy.project.api.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void addUser(User user);

    User getUser(UUID uuid);

    List<User> getAllUsers();

    void updateUser(User user);

    void removeUser(UUID uuid);
}
