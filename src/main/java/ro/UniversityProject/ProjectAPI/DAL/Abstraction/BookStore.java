package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BookDto;

import java.util.List;
@Repository
public interface BookStore extends JpaRepository<BookDto, Long> {
    @Query("select u from Book u")
    List<BookDto> GetAll();

    @Query("select u from Book u where u.name=:name")
    List<BookDto> findByName(@Param("name") String name);

}
