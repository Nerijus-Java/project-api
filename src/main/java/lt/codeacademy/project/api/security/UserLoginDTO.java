package lt.codeacademy.project.api.security;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String username;
    private String password;
}
