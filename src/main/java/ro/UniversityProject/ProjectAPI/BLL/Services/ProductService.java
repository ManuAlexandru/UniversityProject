package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IProductService;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.Converter;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductViewModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductUpdateViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.ProductStore;

import java.util.List;

@Service
public class ProductService implements IProductService {

    ProductStore _productStore;

    public ProductService(ProductStore productStore){
        _productStore=productStore;
    }

    public List<ProductDTO> GetProducts(){

        return _productStore.GetAllProducts();
    }

    public boolean AddProduct(ProductViewModel product){


try {
    _productStore.save(Converter.toProductDto(product));
    return true;
}catch(Exception ex){
    return false;
}
    }

    public List<ProductDTO> GetProductsByUserId(long id){

        try {
            return _productStore.GetAllProductsOfUser(id);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }

        }

    public Boolean DeleteProduct(long id){
        try {
            _productStore.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

   public boolean UpdateProduct(ProductUpdateViewModel product){
        try {
          var result=_productStore.GetProduct(product.getId());
          System.out.println("Id "+product.getId());
          System.out.println("Id "+product.getDescription());
          result.setTitle(product.getTitle());
          result.setDescription(product.getDescription());
_productStore.save(result);
            System.out.println("Update"+ result.getTitle());
        return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        }

  public  boolean UpdatePrice(float price, long id){
        try {
            var result=_productStore.GetProduct(id);
         result.setActualPrice(price);
         _productStore.save(result);
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public ProductDTO GetProduct(long id){
      var result=  _productStore.GetProduct(id);

      return result;
    }
}
