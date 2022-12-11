package ro.UniversityProject.ProjectAPI.BLL.UTILS;

import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

public  class Converter {
    public static UserDTO toUserDTO(RegisterModel userModel){
var userDTO=new UserDTO();
        userDTO.Password=userModel.password;
        userDTO.LastName= userModel.lastName;
        userDTO.FirstName= userModel.firstName;
        userDTO.Email=userModel.email;
return userDTO;
    }
}
