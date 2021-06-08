package lt.codeacademy.project.api.exception;

import lombok.Getter;

@Getter
public class CommentNotFoundException extends RuntimeException {
    private final String message;

    public CommentNotFoundException(String message) {
        this.message = message;
    }
}
