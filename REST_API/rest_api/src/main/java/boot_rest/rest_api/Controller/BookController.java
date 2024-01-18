package boot_rest.rest_api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class BookController {

   // @RequestMapping(value="/books" , method= RequestMethod.GET)
    //@ResponseBody
    @GetMapping("/books")
    public String getBooks(){
        return "this is testing of books";
    }
    
}
