package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ProductDTO;

import java.util.List;
@Repository
public interface ProductStore extends JpaRepository<ProductDTO, Long> {

    @Query("select u from Product u")
    List<ProductDTO> GetAllProducts();

    @Query("select u from Product u where u.user_id=:id")
    List<ProductDTO> GetAllProductsOfUser(long id);

    @Query("select u from Product u where u.Id=:id")
    ProductDTO GetProduct(@Param("id") long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Product u SET u.Title=:title, u.Description=:description where u.Id=:id")
    int updateProduct(@Param("title") String title,@Param("description")String description,@Param("id") long id);

    @Modifying
    @Transactional
    @Query("update Product u SET u.ActualPrice=:price where u.Id=:id")
    int updatePrice(@Param("price") float price,@Param("id") long id);
}
