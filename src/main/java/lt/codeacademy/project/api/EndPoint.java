package lt.codeacademy.project.api;

public interface EndPoint {

    String API_ROOT = "/project/api";

    //controllers
    String API_ROOT_GROUP_CONTROLLER = API_ROOT + "/groups";
    String API_ROOT_COMMENT_CONTROLLER = API_ROOT + "/comment";
    String API_ROOT_POST_CONTROLLER = API_ROOT + "/post";
    String API_ROOT_USER_CONTROLLER = API_ROOT + "/user";


}
