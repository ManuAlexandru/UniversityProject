package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/Auth")
public class AuthController {
    @PostMapping(path = "/Login")
  public void Login(){

  }
  @PostMapping(path="/Register")
  public void Register(){

  }
}
