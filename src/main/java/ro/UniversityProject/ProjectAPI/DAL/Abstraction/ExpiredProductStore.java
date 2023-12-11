package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.ExpiredProductsDTO;

import java.util.List;
@Repository
public interface ExpiredProductStore extends JpaRepository<ExpiredProductsDTO, Long> {
    @Query("select u from ExpiredProduct u")
    List<ExpiredProductsDTO> GetAllExpiredProducts();
}
