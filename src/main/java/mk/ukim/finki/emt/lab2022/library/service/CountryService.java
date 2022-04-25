package mk.ukim.finki.emt.lab2022.library.service;

import mk.ukim.finki.emt.lab2022.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();
    Optional<Country> findById(Long id);
}
