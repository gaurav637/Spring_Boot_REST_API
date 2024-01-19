package boot_rest.rest_api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/books")
    public List<Book> getBooks(){

        return this.bookServices.getAllBooks();
    }

    // get single books
    @GetMapping("/books/{id}")// RequestMapping(value="/value/{id}",method=MappingMethod.GET);
    public Book getBook(@PathVariable("id") int id1){
       return bookServices.getBookById(id1);
    }

    // add new books means add new data 
    @PostMapping("/books")// @ReuestMapping(value="/books",method=RequestMethod.POST);
    public Book addBook1(@RequestBody Book book){
        Book b = bookServices.addBook(book);
        return b;
    }

    // DELETE BOOKS HEANDLER

    @DeleteMapping("/books/{booksId}")// @RequestMapping(value="/value",method=RequestMethod.DELETE);
    public void deleteBook1(@PathVariable("booksId") int id){
        this.bookServices.deleteBook(id);
    }
    
}
