package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAuthService;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.LoginModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;
import ro.UniversityProject.ProjectAPI.Common.Models.GenericResponse;

@RestController

@RequestMapping(path="/api/Home/Auth")
public class AuthController {

  IAuthService _authService;
  //JwtTokenUtil _jwtService;
public AuthController(IAuthService authService ){
  _authService=authService;
  //_jwtService=jwtService;
}
    @PostMapping (path = "/Login")
  public GenericResponse Login(@RequestBody LoginModel user){

var result=_authService.Login(user);
      GenericResponse genericResponse=new GenericResponse();
if(result.compareTo("User does not exist")==0)
{
  genericResponse.message="User does not exist";
  genericResponse.statusCode=500;
  return genericResponse;
}
      if(result.compareTo("Wrong password")==0)
      {
        genericResponse.message="Wrong password";
        genericResponse.statusCode=500;
        return genericResponse;
      }
      genericResponse.message="Auth Succesfully";
      genericResponse.statusCode=200;
      genericResponse.token=result;
      return genericResponse;


  }
  @PostMapping(path="/Register")
  public GenericResponse Register(@RequestBody RegisterModel userModel){
GenericResponse genericResponse=new GenericResponse();

    if(!_authService.Register(userModel)){
      genericResponse.statusCode=500;
      genericResponse.message="The user already exist";
      return genericResponse;
    }
    genericResponse.statusCode=200;
    genericResponse.message="The user was saved";
    return genericResponse;
  }
}
