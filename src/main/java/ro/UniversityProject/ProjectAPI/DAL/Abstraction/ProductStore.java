package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;

import java.util.List;

public interface ProductStore extends JpaRepository<ProductDTO, Long> {

    @Query("select u from Product u")
    List<ProductDTO> GetAllProducts();

    @Query("select u from Product u where u.Id=:id")
    ProductDTO GetProduct(long id);


}
