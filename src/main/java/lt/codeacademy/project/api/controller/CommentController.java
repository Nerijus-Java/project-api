package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.dto.CommentDto;
import lt.codeacademy.project.api.entity.Comment;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.service.CommentsService;
import lt.codeacademy.project.api.service.PostService;
import lt.codeacademy.project.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(EndPoint.API_ROOT_COMMENT_CONTROLLER)
@Api
public class CommentController {

    private final CommentsService commentsService;
    private final PostService postService;
    private final UserService userService;
    private final CommentDto commentDto;

    public CommentController(CommentsService commentsService, PostService postService, UserService userService) {
        this.commentsService = commentsService;
        this.postService = postService;
        this.userService = userService;
        this.commentDto = new CommentDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all Comments", httpMethod = "GET")
    public List<CommentDto> getComments() {
        return commentDto.parseList(commentsService.getAllComments());
    }

    @GetMapping(value = EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Comment by UUID", httpMethod = "GET")
    public CommentDto getComment(@PathVariable(EndPoint.UUID) UUID uuid) {
        return commentDto.parseObject(commentsService.getComment(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , value = EndPoint.BY_POST_UUID)
    @ApiOperation(value = "Create comment", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@Valid @RequestBody Comment comment, @PathVariable(EndPoint.POST_UUID) UUID id,@AuthenticationPrincipal String username) {
        comment.setPost(postService.getPost(id));
        comment.setUser((User) userService.loadUserByUsername(username));
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
    public CommentDto updateComment(@Valid @RequestBody Comment comment) {
        comment.setUser(commentsService.getComment(comment.getId()).getUser());
        return commentDto.parseObject(commentsService.updateComment(comment));
    }
}
