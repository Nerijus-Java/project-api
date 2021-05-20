package lt.codeacademy.project.api.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.project.api.EndPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(EndPoint.API_ROOT_POST_CONTROLLER)
@Api(tags = "Post Controller")
public class PostController {
}
