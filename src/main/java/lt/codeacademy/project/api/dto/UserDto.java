package lt.codeacademy.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.project.api.entity.Role;
import lt.codeacademy.project.api.entity.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;
    private String username;
    private Set<String> roles;

    private String name;
    private String surname;
    private String bio;
    private String password;

    public List<UserDto> parseList(List<User> users) {
        return users.stream().map(e -> parseObject(e)).collect(Collectors.toList());
    }

    public UserDto parseObject(User user) {
        return new UserDto(user.getId().toString(),
                user.getUsername(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()),
                user.getName(),
                user.getSurname(),
                user.getBio(),
                user.getPassword());
    }
}
