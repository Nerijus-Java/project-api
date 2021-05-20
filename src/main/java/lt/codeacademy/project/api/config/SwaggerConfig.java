package lt.codeacademy.project.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    public ApiInfo getApiInfo(){
        return new ApiInfo("Project API",
                "My custom Project API",
                "1.0","Terms",
                new Contact("Nerijus Viliusis","www.codeacademy.com","Nerijus@gmail.com"),
                "Project API License",
                "Project Api URL",
                Collections.emptyList());
    }
    //Link http://localhost:8080/swagger-ui/index.html#/
}
