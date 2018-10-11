package com.ucbcba.Book.controllers;


import com.ucbcba.Book.entities.BookCategory;
import com.ucbcba.Book.services.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BookCategoryController {
    private BookCategoryService bookCategoryService;
    @Autowired
    public void setBookCategoryService(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @RequestMapping(value = "/bookcategory/new", method = RequestMethod.GET)
    public String newBookCategory(Model model) {
        model.addAttribute("bookcategory", new BookCategory());
        return "BookCategoryForm";
    }

    @PostMapping(value = "/bookcategory")
    public String save(@Valid BookCategory bookcategory, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "BookCategoryForm";
        }
        bookCategoryService.saveBookCategory(bookcategory);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/bookcategory/{id}", method = RequestMethod.GET)
    public String showBookCategory(@PathVariable Integer id, Model model) {

        BookCategory bookCategory = bookCategoryService.getBookCategoryById(id);
        model.addAttribute("bookcategory", bookCategory);
        return "categoryshow";
    }

    @RequestMapping(value = "/bookcategory/edit/{id}")
    public String editBookCategory(@PathVariable Integer id, Model model) {
        BookCategory bookCategory = bookCategoryService.getBookCategoryById(id);
        model.addAttribute("categories", bookCategory);
        return "editbookcategory";
    }

    @RequestMapping(value = "/bookcategory/delete/{id}", method = RequestMethod.GET)
    public String deleteBookCategory(@PathVariable Integer id, Model model) {
        bookCategoryService.deleteBookCategory(id);
        return "redirect:/categories";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("categories", bookCategoryService.listAllBookCategory());
        return "categories";
    }

}
