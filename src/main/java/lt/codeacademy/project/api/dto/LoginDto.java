package lt.codeacademy.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class LoginDto {

    private String username;
    private Set<String> roles;
}
