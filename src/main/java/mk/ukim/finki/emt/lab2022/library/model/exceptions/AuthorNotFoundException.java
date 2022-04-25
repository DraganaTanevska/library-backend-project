package mk.ukim.finki.emt.lab2022.library.model.exceptions;

import java.util.function.Supplier;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id){
        super(String.format("Author with id: %d is not found", id));
    }
}
