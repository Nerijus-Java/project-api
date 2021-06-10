package lt.codeacademy.project.api.repository;

import lt.codeacademy.project.api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comment, UUID> {

    @Query("SELECT c FROM Comment c WHERE c.post.id = :uuid")
    List<Comment> findByCommentIdPost(@Param("uuid") UUID uuid);

}
