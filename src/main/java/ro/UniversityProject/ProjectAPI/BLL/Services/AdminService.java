package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAdminService;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.UserStore;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    UserStore _userStore;
    public AdminService(UserStore userStore){

        _userStore = userStore;
    }

    public List<UserDTO> GetUsers(){

        return _userStore.GetAll();
    }
}
