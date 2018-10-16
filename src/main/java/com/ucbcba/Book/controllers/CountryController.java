package com.ucbcba.Book.controllers;

import com.ucbcba.Book.entities.Country;
import com.ucbcba.Book.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CountryController {
    public CountryService countryService;
    @Autowired
    public void setCountryService(CountryService countryService){this.countryService=countryService; }

    @RequestMapping(value = "/country/new", method = RequestMethod.GET)
    public String newCountry(Model model) {
        model.addAttribute("country", new Country());
        return "CountryForm";
    }

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("countries", countryService.listAllCountries());
        return "countries";
    }
    @PostMapping(value = "/country")
    public String save(@Valid Country country, BindingResult bindingResult) {

        countryService.saveCountry(country);
        return "redirect:/countries";
    }
}
