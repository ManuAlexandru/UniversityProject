package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IAdminService;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

import java.util.List;

@RestController
@RequestMapping(path="/api/Admin")
public class AdminController {

IAdminService _adminService;
    @Autowired
    public AdminController(IAdminService adminService){

        _adminService=adminService;
    }

    @GetMapping(path = "/GetAll")
    public List<UserDTO> Login(){
        _adminService.GetUsers();

        return  _adminService.GetUsers();
    }
}
