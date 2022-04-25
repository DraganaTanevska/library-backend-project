package mk.ukim.finki.emt.lab2022.library.web.rest;

import mk.ukim.finki.emt.lab2022.library.model.Book;
import mk.ukim.finki.emt.lab2022.library.model.dto.BookDto;
import mk.ukim.finki.emt.lab2022.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> findAll(){
        return bookService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto).
                map(book -> ResponseEntity.ok().body(book)).
                orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Object> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.delete(id);
        if(this.bookService.findById(id)==null) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/markAsTaken/{id}")
    public ResponseEntity markAsTaken(@PathVariable Long id){
        this.bookService.markAsTaken(id);
        if(this.bookService.findById(id)==null) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/returnBook/{id}")
    public ResponseEntity returnBook(@PathVariable Long id){
        this.bookService.returnBook(id);
        if(this.bookService.findById(id)==null) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
