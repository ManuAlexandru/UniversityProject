package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAuthService;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.Converter;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.UserStore;
import ro.UniversityProject.ProjectAPI.DAL.Stores.UserModel;
@Service
public class AuthService implements IAuthService {
    UserStore _userStore;
    public AuthService(UserStore userStore){
        _userStore = userStore;
    }

    public void Login(UserModel userModel){

    }

    public void Register(UserModel userModel){
//        var isUser=_user_dtoStore.findByEmail(userModel.Email);
//if(isUser!=null)
//    System.out.println("The user already Exist!");
//else

        _userStore.save(Converter.toUserDTO(userModel));

        System.out.println();
    }
}
