package ro.UniversityProject.ProjectAPI.DAL.Abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BookDto;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.WordCounterDto;

import java.util.List;

@Repository
public interface WordCounterStore extends JpaRepository<WordCounterDto, Long> {
    @Query("select u from WordCounter u")
    List<WordCounterDto> GetAll();
}
