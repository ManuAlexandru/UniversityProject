package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserStore extends JpaRepository<UserDTO, Long> {

    @Query("select u from People u")
    List<UserDTO> GetAll();
Optional<UserDTO> findByEmail(String email);

}