package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.entity.Comment;
import lt.codeacademy.project.api.service.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(EndPoint.API_ROOT_COMMENT_CONTROLLER)
@Api(tags = "Comment Controller")
public class CommentController {

    private final CommentsService commentsService;

    public CommentController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all Comments", httpMethod = "GET")
    public List<Comment> getComments() {
        return commentsService.getAllComments();
    }

    @GetMapping(value = EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Comment by UUID", httpMethod = "GET")
    public Comment getComment(@PathVariable(EndPoint.UUID) UUID uuid) {
        return commentsService.getComment(uuid);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create comment", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@Valid @RequestBody Comment comment) {
        commentsService.addComment(comment);
    }

    @DeleteMapping(value = EndPoint.BY_UUID)
    @ApiOperation(value = "Remove Comment", httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable(EndPoint.UUID) UUID id) {
        commentsService.removeComment(id);
    }

    @PutMapping
    @ApiOperation(value = "Update Comment", httpMethod = "PUT")
    public Comment updateProduct(@Valid @RequestBody Comment comment) {
        return commentsService.updateComment(comment);
    }
}
