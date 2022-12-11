package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

import java.util.List;

@Repository
public interface UserStore extends JpaRepository<UserDTO, Long> {

    @Query("select u from People u")
    List<UserDTO> GetAll();
    @Query("select u from People u where u.Email=:email")
    UserDTO findByEmail(@Param("email") String email);


}