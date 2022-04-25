package mk.ukim.finki.emt.lab2022.library.service;

import mk.ukim.finki.emt.lab2022.library.model.Book;
import mk.ukim.finki.emt.lab2022.library.model.dto.BookDto;
import mk.ukim.finki.emt.lab2022.library.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> findById(Long id);

    Book save(String name, Category category, Long author, int availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> delete(Long id);

    Book edit(Long id, String name, Category category, Long author, int availableCopies);

    Optional<Object> edit(Long id, BookDto bookDto);

    Book markAsTaken(Long id);

    Book returnBook(Long id);
}
