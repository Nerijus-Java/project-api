package lt.codeacademy.project.api.exception;

import lombok.Getter;

@Getter
public class ProfilePictureNotFound extends RuntimeException{
    private final String message;

    public ProfilePictureNotFound(String message) {
        this.message = message;
    }
}
