package ro.UniversityProject.ProjectAPI.BLL.UTILS;

import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;
import ro.UniversityProject.ProjectAPI.Common.ViewModels.ProductViewModel;

public  class Converter {
    public static long  weekInMilliseconds=604800000;
    public static UserDTO toUserDTO(RegisterModel userModel){
var userDTO=new UserDTO();
        userDTO.Password=userModel.password;
        userDTO.LastName= userModel.lastName;
        userDTO.FirstName= userModel.firstName;
        userDTO.Email=userModel.email;
return userDTO;
    }

    public static ProductDTO toProductDto(ProductViewModel productViewModel){
        var productDTO=new ProductDTO();
    productDTO.setTitle(productViewModel.title);
    productDTO.setDescription(productViewModel.description);
    productDTO.setStartPrice(productViewModel.price);
    productDTO.setActualPrice(productViewModel.price);
    productDTO.setCreatedDate(productViewModel.createdDate);
productDTO.setEndDate(productViewModel.createdDate+weekInMilliseconds);
productDTO.setPhotoRoute("assets\\img\\NoImage.jpg");
    return productDTO;
    }
}
