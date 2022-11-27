package ro.UniversityProject.ProjectAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@EntityScan("ro.UniversityProject.ProjectAPI.Models.DTOModels")
public class ProjectApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectApiApplication.class, args);
	}

}
