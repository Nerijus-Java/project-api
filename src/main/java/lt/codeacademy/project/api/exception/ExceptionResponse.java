package lt.codeacademy.project.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionResponse {

    private final String message;
    private final int status;

    public ExceptionResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }
}
