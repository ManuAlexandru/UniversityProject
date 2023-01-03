package ro.UniversityProject.ProjectAPI.Common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //to be removed, maybe
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200/")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
