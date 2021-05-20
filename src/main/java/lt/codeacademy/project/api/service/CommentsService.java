package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.Comment;
import lt.codeacademy.project.api.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public void addComment(Comment comment) {
        commentsRepository.save(comment);
    }

    public Comment getComment(UUID uuid) {
        return commentsRepository.getById(uuid);
    }

    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }

    public Comment updateComment(Comment comment) {
        return commentsRepository.save(comment);
    }

    public void removeComment(UUID uuid) {
        commentsRepository.deleteById(uuid);
    }
}
