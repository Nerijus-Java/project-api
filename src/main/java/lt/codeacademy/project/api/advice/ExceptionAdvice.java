package lt.codeacademy.project.api.advice;

import lt.codeacademy.project.api.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(CommentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingCommentNotFoundException(CommentNotFoundException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingGroupNotFoundException(GroupNotFoundException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingPostNotFoundException(PostNotFoundException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingUserNotFoundException(UserNotFoundException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ProfilePictureNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingProfilePictureNotFoundException(ProfilePictureNotFound e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlingFileException(FileException exception){
        return new ExceptionResponse(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
