package mk.ukim.finki.emt.lab2022.library.service.impl;
import mk.ukim.finki.emt.lab2022.library.model.Country;
import mk.ukim.finki.emt.lab2022.library.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.lab2022.library.repository.CountryRepository;
import mk.ukim.finki.emt.lab2022.library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.ofNullable(countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id)));
    }
}
