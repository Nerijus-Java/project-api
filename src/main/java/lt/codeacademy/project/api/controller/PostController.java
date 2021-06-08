package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.dto.PostDto;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.service.GroupService;
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
@RequestMapping(EndPoint.API_ROOT_POST_CONTROLLER)
@Api
public class PostController {

    private final PostService postService;
    private final GroupService groupService;
    private final PostDto postDto;
    private final UserService userService;

    public PostController(PostService postService, GroupService groupService, UserService userService) {
        this.postService = postService;
        this.groupService = groupService;
        this.userService = userService;
        this.postDto = new PostDto();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all Posts", httpMethod = "GET")
    public List<PostDto> getPosts() {
        return postDto.parseList(postService.getAllPosts());
    }

    @GetMapping(value = EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Post by UUID", httpMethod = "GET")
    private PostDto getPost(@PathVariable(EndPoint.UUID) UUID uuid) {
        return postDto.parseObject(postService.getPost(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , value = EndPoint.BY_UUID)
    @ApiOperation(value = "Create Post", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody Post post,
                           @PathVariable(EndPoint.UUID) UUID id,
                           @AuthenticationPrincipal String username) {

        post.setGroup(groupService.getGroup(id));
        post.setUser((User) userService.loadUserByUsername(username));
        postService.addPost(post);
    }

    @DeleteMapping(value = EndPoint.BY_UUID)
    @ApiOperation(value = "Remove Post", httpMethod = "DELETE")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable(EndPoint.UUID) UUID uuid) {
        postService.removePost(uuid);
    }

    @PutMapping
    @ApiOperation(value = "Update Post", httpMethod = "PUT")
    public PostDto updatePost(@Valid @RequestBody Post post) {

        post.setComments(postService.getPost(post.getId()).getComments());
        post.setUser(postService.getPost(post.getId()).getUser());
        post.setGroup(postService.getPost(post.getId()).getGroup());

        return postDto.parseObject(postService.updatePost(post));
    }
}
