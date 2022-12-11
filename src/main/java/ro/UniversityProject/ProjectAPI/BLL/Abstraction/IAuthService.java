package ro.UniversityProject.ProjectAPI.BLL.Abstraction;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.LoginModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;


/**
 *
 */
@Service
public interface IAuthService {
   public String Login(LoginModel user);

   public void Register(RegisterModel userModel);
}
