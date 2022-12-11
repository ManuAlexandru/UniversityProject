package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAuthService;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.LoginModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;

@RestController

@RequestMapping(path="/api/Auth")
public class AuthController {

  IAuthService _authService;
  //JwtTokenUtil _jwtService;
public AuthController(IAuthService authService ){
  _authService=authService;
  //_jwtService=jwtService;
}
    @PostMapping (path = "/Login")
  public String Login(@RequestBody LoginModel user){

var result=_authService.Login(user);

  return result;



  }
  @PostMapping(path="/Register")
  public void Register(@RequestBody RegisterModel userModel){

    _authService.Register(userModel);
  }
}
