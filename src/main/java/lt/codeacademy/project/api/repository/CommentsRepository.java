package lt.codeacademy.project.api.repository;

import lt.codeacademy.project.api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comment, UUID> {
}
