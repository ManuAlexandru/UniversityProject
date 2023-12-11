package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BoughtProductsDTO;

import java.util.List;
@Repository
public interface BoughtProductStore extends JpaRepository<BoughtProductsDTO, Long> {

    @Query("select u from BoughtProduct u")
    List<BoughtProductsDTO> GetAllBoughtProducts();

    @Query("select u from BoughtProduct u where u.buyer_id=:id")
    List<BoughtProductsDTO> GetAllBoughtProductsOfUser(long id);
}
