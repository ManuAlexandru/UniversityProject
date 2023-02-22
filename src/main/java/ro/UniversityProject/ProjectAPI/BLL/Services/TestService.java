package ro.UniversityProject.ProjectAPI.BLL.Services;

import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.BLL.Abstraction.ITestService;
import ro.UniversityProject.ProjectAPI.BLL.ViewModels.BookViewModel;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.BookDto;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.WordCounterDto;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.BookStore;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.WordCounterStore;

import java.util.ArrayList;
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
        book.author=bookViewModel.author;
        book.year=bookViewModel.year;
        book.name= bookViewModel.name;
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
       List listToBeSent=new ArrayList<BookDto>();

    int size=result.size();

       for(int i=0;i<size;i++){
           var book=result.get(i);

           if(book.name.contains(text))//daca cuv introdus de la user nu e inclus in numele cartii scot cartea
           {
               listToBeSent.add(book);
           }
       }
       if(listToBeSent.size()==0)//daca lista e goala introduc in db cuv de la user
       {
           WordCounterDto wordCounterDto=new WordCounterDto();
           wordCounterDto.insertedWord=text;
           _wordCounter.save(wordCounterDto);
           return listToBeSent;//momentan intorc null, stiu ca nu i ok dar momentan asta e singura varianta la care m am gandit
       }

       return listToBeSent;
}

    public List<WordCounterDto> getAllWords(){
       return _wordCounter.GetAll();
    }
}
