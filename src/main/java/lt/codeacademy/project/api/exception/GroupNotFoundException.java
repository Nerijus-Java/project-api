package lt.codeacademy.project.api.exception;

import lombok.Getter;

@Getter
public class GroupNotFoundException extends RuntimeException {
    private final String message;

    public GroupNotFoundException(String message) {
        this.message = message;
    }
}
