package boot_rest.rest_api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import boot_rest.rest_api.Entities.Book;
import boot_rest.rest_api.Services.BookServices;

// @Controller
@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;



   // @RequestMapping(value="/books" , method= RequestMethod.GET)
    //@ResponseBody
    // get all books 
    // @GetMapping("/books")
    // public List<Book> getBooks(){

    //     return this.bookServices.getAllBooks();
    // }

    // body of create ResponsBody() handling.

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> ls1 = bookServices.getAllBooks();
        if(ls1.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ls1));
    }



    // get single books
    // @GetMapping("/books/{id}")// RequestMapping(value="/value/{id}",method=MappingMethod.GET);
    // public Book getBook(@PathVariable("id") int id1){
    //    return bookServices.getBookById(id1);
    // }

  /// create single book not found ResponseEntity 404 


    @GetMapping("/books{booksid}")
    public ResponseEntity<Book> getBook(@PathVariable("booksId") int id1){
        Book b1  = bookServices.getBookById(id1);
        if(b1==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b1));
    }
  


    // add new books means add new data 
    // @PostMapping("/books")// @ReuestMapping(value="/books",method=RequestMethod.POST);
    // public Book addBook1(@RequestBody Book book){
    //     Book b = bookServices.addBook(book);
    //     return b;
    // }

    // hander post  exception 

    @PostMapping("/books")
    public ResponseEntity<Book> addBook1(@RequestBody Book book){
       Book b = null;
       try{
        b = bookServices.addBook(book);
        return ResponseEntity.of(Optional.of(b));
       }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }



    // DELETE BOOKS HANDLER

    // @DeleteMapping("/books/{booksId}")// @RequestMapping(value="/value",method=RequestMethod.DELETE);
    // public void deleteBook1(@PathVariable("booksId") int id){
    //     this.bookServices.deleteBook(id);
    // }

    // Hander DELETE EXCEPTION

    @DeleteMapping("/books/{booksId}")
    public ResponseEntity<Void> deleteBook1(@PathVariable("booksId") int id){
        try{
            this.bookServices.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // update book handler

    @PutMapping("/books/{bookId}")
    public Book updateBook1(@RequestBody Book book, @PathVariable("bookId") int bid){

       this.bookServices.updateBook(book,bid); 
       return book;
    }

}

