package mk.ukim.finki.emt.lab2022.library.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.lab2022.library.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Long author;
    private int availableCopies;
    public BookDto(){}

    public BookDto(String name, Category category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
