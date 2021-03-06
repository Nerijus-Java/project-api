package lt.codeacademy.project.api.service;

import lt.codeacademy.project.api.entity.ProfilePicture;
import lt.codeacademy.project.api.entity.User;
import lt.codeacademy.project.api.exception.FileException;
import lt.codeacademy.project.api.exception.ProfilePictureNotFound;
import lt.codeacademy.project.api.repository.ProfilePictureRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
import java.util.UUID;

@Service
public class ProfilePictureService {

    private static final int MAX_SIZE = 10000000;
    private final Set<String> types;

    private final ProfilePictureRepository profilePictureRepository;
    private final UserService userService;

    public ProfilePictureService(ProfilePictureRepository profilePictureRepository, UserService userService) {
        this.userService = userService;
        this.types = Set.of(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE);
        this.profilePictureRepository = profilePictureRepository;
    }

    public ProfilePicture getProfilePicByIdFromDataBaseSystem(UUID uuid) {
        return profilePictureRepository.findById(uuid).orElseThrow(() -> new ProfilePictureNotFound("File dose not exist"));
    }

    public void deleteProfilePic(UUID uuid){
        profilePictureRepository.deleteById(profilePictureRepository.findByUserId(uuid).getId());
    }

    public ProfilePicture getProfilePicByUserIdFromDataBase(UUID uuid) {
        return profilePictureRepository.findByUserId(uuid);
    }

    public void saveProfilePicAsBlob(MultipartFile multipartFile, String username) {

        User user = (User) userService.loadUserByUsername(username);

        validateFile(multipartFile);

        if (profilePictureRepository.findByUserId(user.getId()) != null) {
            profilePictureRepository.deleteById(profilePictureRepository.findByUserId(user.getId()).getId());
        }

        try {
            ProfilePicture profilePicture = new ProfilePicture();
            profilePicture.setFileName(multipartFile.getOriginalFilename());
            profilePicture.setBytes(multipartFile.getBytes());
            profilePicture.setSize(multipartFile.getSize());
            profilePicture.setMediaType(multipartFile.getContentType());
            profilePicture.setUser((User) userService.loadUserByUsername(username));
            profilePictureRepository.save(profilePicture);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    private void validateFile(MultipartFile file) {
        if (file.getSize() > MAX_SIZE) {
            throw new FileException("File is to big");
        }
        if (!types.contains(file.getContentType())) {
            throw new FileException("File type not supported");
        }
    }


}
