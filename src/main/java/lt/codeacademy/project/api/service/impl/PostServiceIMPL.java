package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Group;
import lt.codeacademy.project.api.entity.Post;
import lt.codeacademy.project.api.service.ServiceInterface.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceIMPL implements PostService {
    @Override
    public void addPost(Post post) {

    }

    @Override
    public Group getPost(UUID uuid) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void removePost(UUID uuid) {

    }
}
