package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.UserStore;

import java.util.List;

@RestController
@RequestMapping(path="/api/Admin")
public class AdminController {

    UserStore _userDtoStore;
    public AdminController(UserStore userDtoStore){
        _userDtoStore=userDtoStore;
    }

    @GetMapping(path = "/GetAll")
    public List<UserDTO> Login(){
        _userDtoStore.GetAll();


        return  _userDtoStore.GetAll();
   // return null;
    }
}
