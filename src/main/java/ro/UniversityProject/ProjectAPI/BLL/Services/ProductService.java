package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IProductService;
import ro.UniversityProject.ProjectAPI.BLL.UTILS.Converter;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductUpdateViewModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BoughtProductsDTO;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ExpiredProductsDTO;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.BoughtProductStore;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.ExpiredProductStore;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.ProductStore;

import java.util.List;

@Service
public class ProductService implements IProductService {

    ProductStore _productStore;
    ExpiredProductStore _expiredProductStore;
    BoughtProductStore _boughtProductStore;

    public ProductService(ProductStore productStore, ExpiredProductStore expiredProductStore, BoughtProductStore boughtProductStore){
        _productStore=productStore;
        _boughtProductStore=boughtProductStore;
        _expiredProductStore=expiredProductStore;
    }

    public List<ProductDTO> GetProducts(){

var products=_productStore.GetAllProducts();

        return _productStore.GetAllProducts();
    }

   public List<BoughtProductsDTO> GetAllBoughtProductsById(long id){
        try{
            var result=_boughtProductStore.GetAllBoughtProductsOfUser(id);
            return  result;
        }catch(Exception ex){return null;}

    }

  public  List<ExpiredProductsDTO> GetAllExpiredProducts(){

        try{
            return _expiredProductStore.GetAllExpiredProducts();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void CheckIfProductIsExpired(){
        var products=_productStore.GetAllProducts();

        if(products==null)
            return;

        for(int i=0;i<products.size();i++)     {
            var time=products.get(i).getEndDate()- System.currentTimeMillis();
            var buyerId= products.get(i).getBuyer_id();
            if((time==0 || time<0))
            if(buyerId==0){

_expiredProductStore.save(Converter.toExpiredProductDto(products.get(i)));

_productStore.deleteById(products.get(i).getId());
            }
            else
            {
_boughtProductStore.save(Converter.toBoughtProductDTO(products.get(i)));

                _productStore.deleteById(products.get(i).getId());
            }
        }
    }

public boolean BuyNow(ProductUpdateViewModel productUpdateViewModel){
try{
    _boughtProductStore.save(Converter.FromViewToBoughtProductDTO(productUpdateViewModel));
    _productStore.deleteById(productUpdateViewModel.getId());
    return true;
}catch(Exception ex) {
    return false;
}
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

  public  boolean UpdatePrice(ProductUpdateViewModel productUpdateViewModel){
        try {
            var result=_productStore.GetProduct(productUpdateViewModel.getId());
         result.setActualPrice(productUpdateViewModel.getActualPrice());
         result.setBuyer_id(productUpdateViewModel.getBuyerId());
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
