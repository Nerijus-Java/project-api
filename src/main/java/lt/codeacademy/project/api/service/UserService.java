package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.exception.UserNotFoundException;
import lt.codeacademy.project.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUser(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(() -> new UserNotFoundException("User does not exist"));
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new UserNotFoundException("User dose not exist"));
    }
}
