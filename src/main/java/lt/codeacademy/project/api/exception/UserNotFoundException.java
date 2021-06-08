package lt.codeacademy.project.api.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
}
