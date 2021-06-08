package lt.codeacademy.project.api.controller;

import lt.codeacademy.project.api.dto.LoginDto;
import lt.codeacademy.project.api.entity.Role;
import lt.codeacademy.project.api.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public LoginDto login(@AuthenticationPrincipal User user){
        return new LoginDto(user.getUsername(),user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
    }

}
