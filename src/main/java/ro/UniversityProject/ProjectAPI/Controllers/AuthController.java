package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/Auth")
public class AuthController {
    @GetMapping(path = "/Login")
  public String Login(){
return "Login";
  }
  @PostMapping(path="/Register")
  public void Register(){

  }
}
