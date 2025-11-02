package com.bookstore.controller; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/api/books")
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
   }
   @PutMapping("/{id}")
   public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
      Book existingBook = bookRepository.findById(id).orElseThrow();
      existingBook.setTitle(updatedBook.getTitle());
      existingBook.setAuthor(updatedBook.getAuthor());
      existingBook.setPrice(updatedBook.getPrice());
      return bookRepository.save(existingBook);
}

}
