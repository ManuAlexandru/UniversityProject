package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.ITestService;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.BookViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BookDto;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.WordCounterDto;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.BookStore;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.WordCounterStore;

import java.util.List;
@Service
public class TestService implements ITestService {
    private BookStore _bookStore;
    private WordCounterStore _wordCounter;

   public  TestService(BookStore bookStore,WordCounterStore wordCounterStore){
        _bookStore=bookStore;
        _wordCounter=wordCounterStore;
    }

    public void addBook(BookViewModel bookViewModel){
        BookDto book=new BookDto();
        book.author=bookViewModel.Author;
        book.year=bookViewModel.Year;
        book.name= bookViewModel.Name;
        try {
            _bookStore.save(book);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
public List<BookDto> getAllBooks(){

       return _bookStore.GetAll();
}

public List<BookDto> getBookByName(String text){
       var result=_bookStore.GetAll();
       var listToBeSent=result;//de aici o sa scot cartile ale caror nume nu contine text ul introdus de user

       for(int i=0;i<result.size();i++){
           var book=result.get(i);
           if(!book.name.contains(text))//daca cuv introdus de la user nu e inclus in numele cartii scot cartea
               listToBeSent.remove(i);
       }

       if(listToBeSent.size()==0)//daca lista e goala introduc in db cuv de la user
       {
           WordCounterDto wordCounterDto=new WordCounterDto();
           wordCounterDto.insertedWord=text;
           _wordCounter.save(wordCounterDto);
           return null;//momentan intorc null, stiu ca nu i ok dar momentan asta e singura varianta la care m am gandit
       }

       return result;
}

    public List<WordCounterDto> getAllWords(){
       return _wordCounter.GetAll();
    }
}
