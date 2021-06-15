package lt.codeacademy.project.api.repository;

import lt.codeacademy.project.api.entity.ProfilePicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, UUID> {

    ProfilePicture findByUserId(UUID uuid);
}
