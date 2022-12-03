package ro.UniversityProject.ProjectAPI.BLL.Abstraction;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.DAL.Stores.UserModel;

/**
 *
 */
@Service
public interface IAuthService {
   public void Login(UserModel userModel);

   public void Register(UserModel userModel);
}
