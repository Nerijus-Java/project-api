package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.repository.PostRepository;
import lt.codeacademy.project.api.service.ServiceInterface.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceIMPL implements PostService {

    private final PostRepository postRepository;

    public PostServiceIMPL(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPost(UUID uuid) {
        return postRepository.getById(uuid);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void removePost(UUID uuid) {
        postRepository.deleteById(uuid);
    }
}
