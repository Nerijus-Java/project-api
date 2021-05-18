package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.repository.UserRepository;
import lt.codeacademy.project.api.service.ServiceInterface.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceIMPL implements UserService {

    private final UserRepository userRepository;

    public UserServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(UUID uuid) {
        return userRepository.getById(uuid);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
