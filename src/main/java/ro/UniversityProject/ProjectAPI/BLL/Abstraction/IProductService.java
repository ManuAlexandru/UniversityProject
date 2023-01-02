package ro.UniversityProject.ProjectAPI.BLL.Abstraction;

import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> GetProducts();

    void AddProduct(ProductDTO productDTO);
    void DeleteProduct(long id);
}
