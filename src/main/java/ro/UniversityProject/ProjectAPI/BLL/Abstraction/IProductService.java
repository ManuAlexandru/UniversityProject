package ro.UniversityProject.ProjectAPI.BLL.Abstraction;

import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductUpdateViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.ProductViewModel;

import java.util.List;

public interface IProductService {

    List<ProductDTO> GetProducts();

     boolean AddProduct(ProductViewModel product);
     Boolean DeleteProduct(long id);
     List<ProductDTO> GetProductsByUserId(long id);

    ProductDTO GetProduct(long id);
    boolean UpdateProduct(ProductUpdateViewModel product);
    boolean UpdatePrice(float price, long id);
}
