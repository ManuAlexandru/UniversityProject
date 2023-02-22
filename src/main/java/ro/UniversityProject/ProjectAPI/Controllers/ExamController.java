package ro.UniversityProject.ProjectAPI.Controllers;

import org.springframework.web.bind.annotation.*;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.ITestService;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.BookViewModel;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.FilterBooks;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BookDto;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.WordCounterDto;

import java.util.List;

@RestController
@RequestMapping(path="/api/Exam")
public class ExamController {

    private ITestService _service;
    public ExamController(ITestService testService){
        _service=testService;
    }

    @PostMapping(path="/CreateBook")
    public void insertBook(@RequestBody BookViewModel bookViewModel){
_service.addBook(bookViewModel);
    }

    @PostMapping(path="/SearchBook")
    public List<BookDto> GetBookByFilter(@RequestBody FilterBooks filter){
System.out.println(filter.text);
        return _service.getBookByName(filter.text);
    }

    @GetMapping(path="/GetAllBooks")
    public List<BookDto> GetAllBooks(){
        return _service.getAllBooks();
    }

    @GetMapping(path="/GetWordsFromUser")
    public List<WordCounterDto> GetAllWords(){
        return _service.getAllWords();
    }
}
