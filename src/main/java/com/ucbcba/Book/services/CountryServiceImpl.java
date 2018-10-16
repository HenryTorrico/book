package com.ucbcba.Book.services;


import com.ucbcba.Book.entities.Country;
import com.ucbcba.Book.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{


    public CountryRepository countryRepository;

    @Autowired
    @Qualifier(value = "countryRepository")
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Iterable<Country> listAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country findCountry(Integer id) {
        Optional<Country> opt;
        opt = countryRepository.findById(id);
        return opt.get();
    }

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);

    }
    @Override
    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);

    }
}
