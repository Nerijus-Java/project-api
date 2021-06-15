package lt.codeacademy.project.api;

public interface EndPoint {

    String PUBLIC = "/public";

    String UUID = "UUID";
    String POST_UUID = "POSTID";
    String API_ROOT = "/project/api";
    String GROUP = "/group";
    String POST = "/post";
    String COMMENT = "/comment";
    String LOGIN = "/login";
    String USER = "/user";
    String PROFILE_PICTURE = "/picture";
    //controllers


    String BY_UUID = "/{" + UUID + "}";
    String BY_POST_UUID = "/{" + POST_UUID + "}";
}
