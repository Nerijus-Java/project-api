package lt.codeacademy.project.api.service.ServiceInterface;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    void addPost(Post post);

    Post getPost(UUID uuid);

    List<Post> getAllPosts();

    void updatePost(Post post);

    void removePost(UUID uuid);
}
