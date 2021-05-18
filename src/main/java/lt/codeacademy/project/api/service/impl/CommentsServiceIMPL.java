package lt.codeacademy.project.api.service.impl;

import lt.codeacademy.project.api.entity.Comment;
import lt.codeacademy.project.api.repository.CommentsRepository;
import lt.codeacademy.project.api.service.ServiceInterface.CommentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentsServiceIMPL implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceIMPL(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public void addComment(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public Comment getComment(UUID uuid) {
        return commentsRepository.getById(uuid);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public void updateComment(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public void removeComment(UUID uuid) {
        commentsRepository.deleteById(uuid);
    }
}
