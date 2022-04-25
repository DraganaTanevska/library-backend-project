package mk.ukim.finki.emt.lab2022.library.config;

import mk.ukim.finki.emt.lab2022.library.model.Author;
import mk.ukim.finki.emt.lab2022.library.model.Book;
import mk.ukim.finki.emt.lab2022.library.model.Country;
import mk.ukim.finki.emt.lab2022.library.model.enumerations.Category;
import mk.ukim.finki.emt.lab2022.library.repository.AuthorRepository;
import mk.ukim.finki.emt.lab2022.library.repository.BookRepository;
import mk.ukim.finki.emt.lab2022.library.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initData() {
        //Countries
        List<Country> countries=new ArrayList<>();
        List<Author> authors=new ArrayList<>();
        for(int i=0;i<8;i++){
            Country country=new Country("Country "+i,"Continent "+ i);
            countries.add(country);
            countryRepository.save(country);
        }

        //Authors
        for(int i=0;i<8;i++){
            Author author=new Author("Name"+i,"Surname"+i,countries.get(i));
            authors.add(author);
            authorRepository.save(author);
        }
        //Books
        for(int i=0;i<7;i++){
            Book book=new Book("Book "+i,Category.values()[i],authors.get(i),i*5);
            bookRepository.save(book);
        }

    }
}