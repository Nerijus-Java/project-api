package lt.codeacademy.project.api.repository;

import lt.codeacademy.project.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    @Query("SELECT p FROM Post p WHERE p.group.id = :uuid")
    List<Post> findByPostIdGroup(@Param("uuid") UUID uuid);
}
