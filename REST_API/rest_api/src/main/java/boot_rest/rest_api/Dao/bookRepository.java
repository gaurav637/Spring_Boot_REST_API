package boot_rest.rest_api.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import boot_rest.rest_api.Entities.Book;

@Component
public interface bookRepository extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
