package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.service.ServiceInterface.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceIMPL implements UserService {

    @Override
    public void addUser(User user) {

    }

    @Override
    public Group getUser(UUID uuid) {
        return null;
    }

    @Override
    public List<Post> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(UUID uuid) {

    }
}
