package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.exception.PostNotFoundException;
import lt.codeacademy.project.api.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Post getPost(UUID uuid) {
        return postRepository.findById(uuid).orElseThrow(()-> new PostNotFoundException("Post dose not exist"));
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void removePost(UUID uuid) {
        postRepository.delete(postRepository.getOne(uuid));
    }
}
