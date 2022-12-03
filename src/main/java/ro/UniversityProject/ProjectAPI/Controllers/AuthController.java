package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.*;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAuthService;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic.JwtTokenUtil;
import ro.UniversityProject.ProjectAPI.DAL.Stores.UserModel;

@RestController

@RequestMapping(path="/api/Auth")
public class AuthController {

  IAuthService _authService;
  JwtTokenUtil _jwtService;
public AuthController(IAuthService authService,JwtTokenUtil jwtService){
  _authService=authService;
  _jwtService=jwtService;
}
    @GetMapping(path = "/Login")
  public String Login(){
return "Login";
  }
  @PostMapping(path="/Register")
  public void Register(@RequestBody UserModel userModel){

    _authService.Register(userModel);
  }
}
