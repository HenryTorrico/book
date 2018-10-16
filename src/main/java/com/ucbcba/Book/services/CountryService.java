package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.Country;

public interface CountryService {

    Iterable<Country> listAllCountries();
    Country findCountry(Integer id);
    void saveCountry(Country country);
    void deleteCountry(Integer id);
}
