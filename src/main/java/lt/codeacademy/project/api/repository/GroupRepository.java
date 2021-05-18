package lt.codeacademy.project.api.repository;

import lt.codeacademy.project.api.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
