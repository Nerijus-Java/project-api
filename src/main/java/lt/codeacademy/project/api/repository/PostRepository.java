package lt.codeacademy.project.api.repository;

import lt.codeacademy.project.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
