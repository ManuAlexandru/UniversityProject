package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/Home")
public class HomeController {

    @GetMapping(path = "/GetAll")
    public String Login(){


        return "Login";
    }
}
