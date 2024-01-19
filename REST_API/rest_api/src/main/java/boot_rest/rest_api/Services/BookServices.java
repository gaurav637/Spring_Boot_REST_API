package boot_rest.rest_api.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import boot_rest.rest_api.Entities.Book;

@Component
public class BookServices {

    private static List<Book> ls = new ArrayList<>();
    static{
        ls.add(new Book(12,"python","guido vanson"));
        ls.add(new Book(13,"let us c","denish ritchi"));
        ls.add(new Book(34,"java","sunmicrosystem"));
        ls.add(new Book(1,"pcat","xyz1"));
        ls.add(new Book(2,"os","xyz2"));
        ls.add(new Book(3,"c++","xyz3"));
        ls.add(new Book(4,"js","xyz4"));
        ls.add(new Book(5,"html","xyz5"));
        ls.add(new Book(6,"css","xyz6"));
    }

    // get all books

    public List<Book> getAllBooks(){
        return ls;
    }

    // get a single book

    public Book getBookById(int id){
        Book book = null;
        book = ls.stream().filter(e-> e.getId()==id).findFirst().get();
        return book;
    }
    
}
