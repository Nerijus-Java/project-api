package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.service.ProfilePictureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(EndPoint.API_ROOT)
@Api
public class ProfilePictureController {

    private final ProfilePictureService profilePictureService;

    public ProfilePictureController(ProfilePictureService profilePictureService) {
        this.profilePictureService = profilePictureService;
    }

    @ApiOperation(value = "Save Picture as BLOB",  httpMethod = "POST")
    @PostMapping(EndPoint.PROFILE_PICTURE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProfilePictureAsBlob(@RequestParam MultipartFile multipartFile) {
        profilePictureService.saveProfilePicAsBlob(multipartFile);
    }


}
