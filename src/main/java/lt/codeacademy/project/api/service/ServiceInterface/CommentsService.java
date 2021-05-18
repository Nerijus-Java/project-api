package lt.codeacademy.project.api.service.ServiceInterface;

import lt.codeacademy.project.api.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentsService {

    void addComment(Comment comment);

    Comment getComment(UUID uuid);

    List<Comment> getAllComments();

    void updateComment(Comment comment);

    void removeComment(UUID uuid);
}
