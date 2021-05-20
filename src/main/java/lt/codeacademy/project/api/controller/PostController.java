package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(EndPoint.API_ROOT_POST_CONTROLLER)
@Api
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all Posts", httpMethod = "GET")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(value = EndPoint.BY_UUID, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Post by UUID", httpMethod = "GET")
    private Post getPost(@PathVariable(EndPoint.UUID) UUID uuid) {
        return postService.getPost(uuid);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Post", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody Post post) {
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
    public Post updatePost(@Valid @RequestBody Post post) {
        return postService.updatePost(post);
    }
}
