package ro.UniversityProject.ProjectAPI.BLL.UTILS;

import ro.UniversityProject.ProjectAPI.DAL.Stores.UserModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

public  class Converter {
    public static UserDTO toUserDTO(UserModel userModel){
var userDTO=new UserDTO();
        userDTO.Password=userModel.Password;
        userDTO.LastName= userModel.LastName;
        userDTO.FirstName= userModel.FirstName;
        userDTO.Email=userModel.Email;
return userDTO;
    }
}
