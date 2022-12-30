package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAuthService;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.Converter;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic.JwtTokenUtil;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic.MyUserDetails;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.LoginModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.UserStore;

@Service
public class AuthService implements IAuthService {
    UserStore _userStore;
    public AuthService(UserStore userStore){
        _userStore = userStore;
    }

    public String Login(LoginModel user){


        var dbUser=_userStore.findByEmail(user.email);
if(dbUser==null)
    return "User does not exist";
if(!dbUser.Password.equals(user.password))
    return "Wrong password";
        JwtTokenUtil token =new JwtTokenUtil();
        MyUserDetails userDetails=new MyUserDetails(dbUser);
    var generatedToken=token.generateToken(userDetails);
return generatedToken;

    }

    public Boolean Register(RegisterModel userModel){
        var isUser=_userStore.findByEmail(userModel.email);
if(isUser!=null)
    return false;
else
        _userStore.save(Converter.toUserDTO(userModel));
return true;
    }
}
