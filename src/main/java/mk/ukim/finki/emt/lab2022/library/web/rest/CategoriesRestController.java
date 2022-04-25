package mk.ukim.finki.emt.lab2022.library.web.rest;
import mk.ukim.finki.emt.lab2022.library.model.enumerations.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @GetMapping
    public List<Category> findAll(){
        return List.of(Category.values());
    }
}
