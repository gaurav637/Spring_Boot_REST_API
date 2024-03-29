package boot_rest.rest_api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import boot_rest.rest_api.Dao.bookRepository;
import boot_rest.rest_api.Entities.Book;

@Component
public class BookServices {

    @Autowired
    private bookRepository brt;

    //private static List<Book> ls = new ArrayList<>();
    // static{
    //     ls.add(new Book(12,"python","guido vanson"));
    //     ls.add(new Book(13,"let us c","denish ritchi"));
    //     ls.add(new Book(34,"java","sunmicrosystem"));
    //     ls.add(new Book(1,"pcat","xyz1"));
    //     ls.add(new Book(2,"os","xyz2"));
    //     ls.add(new Book(3,"c++","xyz3"));
    //     ls.add(new Book(4,"js","xyz4"));
    //     ls.add(new Book(5,"html","xyz5"));
    //     ls.add(new Book(6,"css","xyz6"));
    // }




    // get all books

    public List<Book> getAllBooks(){
        List<Book> ls = (List<Book>)this.brt.findAll();
        return ls;
    }

    // get a single book

    public Book getBookById(int id){
        Book book = null;
        try{
            //book = ls.stream().filter(e-> e.getId()==id).findFirst().get();

            book = brt.findById(id);
        }catch(Exception e){
            System.out.println(e.getMessage());// printStackTrace(e);
        }
        
        return book;
    }

    // Add the new book

    public Book addBook(Book b){
        Book result = brt.save(b);
        return result;
    }

    // delete book 

    public void deleteBook(int bid){// ls = ls.stream().filter(b1-> b1.getId()!=id).collect(Collectors.toList())
        // ls = ls.stream().filter(b1-> {
        //     if(b1.getId() != bid){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }).collect(Collectors.toList());
        brt.deleteById(bid);
    }

    // update books

   public void updateBook(Book book,int bid){
    //    ls = ls.stream().map(e-> {
    //         if(e.getId()==bid){
    //             e.setTitle(book.getTitle());
    //             e.setAuthor(book.getAuthor());
    //         }
    //         return e;
    //    }).collect(Collectors.toList());

    book.setId(bid);
    brt.save(book);
   }
    
}
