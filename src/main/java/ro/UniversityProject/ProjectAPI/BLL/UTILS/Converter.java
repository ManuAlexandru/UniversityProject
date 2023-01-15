package ro.UniversityProject.ProjectAPI.BLL.UTILS;

import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductUpdateViewModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductViewModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.RegisterModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BoughtProductsDTO;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ExpiredProductsDTO;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

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
    productDTO.setEndDate(productViewModel.endDate);
productDTO.setUser_id(productViewModel.userId);
productDTO.setPhotoRoute("assets\\img\\NoImage.jpg");
productDTO.setBuyer_id(productViewModel.buyerId);
    return productDTO;
    }

    public static ExpiredProductsDTO toExpiredProductDto(ProductDTO product){
        var expiredProduct=new ExpiredProductsDTO();
        expiredProduct.setTitle(product.getTitle());
        expiredProduct.setDescription(product.getDescription());
        expiredProduct.setPhotoRoute(product.getPhotoRoute());
        expiredProduct.setUser_id(product.getUser_id());
        return expiredProduct;
    }

    public static BoughtProductsDTO toBoughtProductDTO(ProductDTO product){
        var boughtProduct=new BoughtProductsDTO();
boughtProduct.setBoughtPrice(product.getActualPrice());
boughtProduct.setBuyer_id(product.getBuyer_id());
boughtProduct.setDescription(product.getDescription());
boughtProduct.setPhotoRoute(product.getPhotoRoute());
boughtProduct.setTitle(product.getTitle());
boughtProduct.setPhotoRoute("assets\\img\\NoImage.jpg");

return boughtProduct;
    }

    public static BoughtProductsDTO FromViewToBoughtProductDTO(ProductUpdateViewModel productViewModel){
        var boughtProduct=new BoughtProductsDTO();
        boughtProduct.setBoughtPrice(productViewModel.getActualPrice());
        boughtProduct.setBuyer_id(productViewModel.getBuyerId());
        boughtProduct.setDescription(productViewModel.getDescription());
        boughtProduct.setPhotoRoute(productViewModel.getPhoto());
        boughtProduct.setTitle(productViewModel.getTitle());

        return boughtProduct;
    }
}
