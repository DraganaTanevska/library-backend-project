package mk.ukim.finki.emt.lab2022.library.repository;

import mk.ukim.finki.emt.lab2022.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
