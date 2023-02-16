package ro.UniversityProject.ProjectAPI.BLL.Abstraction;

import ro.UniversityProject.ProjectAPI.BLL.ViewModels.BookViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BookDto;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.WordCounterDto;

import java.util.List;

public interface ITestService {
     void addBook(BookViewModel bookViewModel);
    List<BookDto> getAllBooks();
    List<BookDto> getBookByName(String text);
    public List<WordCounterDto> getAllWords();
}
