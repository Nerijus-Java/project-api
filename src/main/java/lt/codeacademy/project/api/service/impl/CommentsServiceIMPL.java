package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Comment;
import lt.codeacademy.project.api.service.ServiceInterface.CommentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentsServiceIMPL implements CommentsService {
    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public Comment getComment(UUID uuid) {
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void removeComment(UUID uuid) {

    }
}
