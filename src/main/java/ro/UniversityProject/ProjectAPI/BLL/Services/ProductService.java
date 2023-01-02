package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.IProductService;
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

    public void AddProduct(ProductDTO productDTO){

        _productStore.save(productDTO);
    }

    public void DeleteProduct(long id){
        _productStore.deleteById(id);
    }
}
