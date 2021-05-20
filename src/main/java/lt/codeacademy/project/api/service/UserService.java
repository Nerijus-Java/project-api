package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUser(UUID uuid) {
        return userRepository.getById(uuid);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}