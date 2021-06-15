package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacademy.project.api.EndPoint;
import lt.codeacademy.project.api.entity.ProfilePicture;
import lt.codeacademy.project.api.service.ProfilePictureService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

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
    public void saveProfilePictureAsBlob(@RequestParam MultipartFile multipartFile, @AuthenticationPrincipal String username ) {
        profilePictureService.saveProfilePicAsBlob(multipartFile, username);
    }

    @ApiOperation(value = "Get Picture by id as Blob",  httpMethod = "GET")
    @GetMapping( EndPoint.PUBLIC + EndPoint.PROFILE_PICTURE + EndPoint.BY_UUID)
    public ResponseEntity<Resource> getFileByUUIDAsBlob(@PathVariable(EndPoint.UUID) UUID uuid) {

        ProfilePicture profilePicture = profilePictureService.getProfilePicByIdFromDataBaseSystem(uuid);
        Resource resource = new ByteArrayResource(profilePicture.getBytes());

        return ResponseEntity.ok()
                .headers(getHttpHeader(profilePicture.getFileName()))
                .contentType(MediaType.valueOf(profilePicture.getMediaType()))
                .body(resource);
    }

    @ApiOperation(value = "Get Picture by UserId as Blob",  httpMethod = "GET")
    @GetMapping( EndPoint.PUBLIC + EndPoint.PROFILE_PICTURE + EndPoint.BY_UUID + EndPoint.USER)
    public ResponseEntity<Resource> getFileByUserUUIDAsBlob(@PathVariable(EndPoint.UUID) UUID uuid){

        ProfilePicture profilePicture = profilePictureService.getProfilePicByUserIdFromDataBase(uuid);
        Resource resource = new ByteArrayResource(profilePicture.getBytes());

        return ResponseEntity.ok()
                .headers(getHttpHeader(profilePicture.getFileName()))
                .contentType(MediaType.valueOf(profilePicture.getMediaType()))
                .body(resource);
    }

    private HttpHeaders getHttpHeader(String fileName){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        return headers;
    }
}
