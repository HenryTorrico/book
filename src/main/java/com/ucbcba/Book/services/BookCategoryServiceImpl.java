package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.Book;
import com.ucbcba.Book.entities.BookCategory;
import com.ucbcba.Book.repositories.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService{
    public BookCategoryRepository bookCategoryRepository;

    @Autowired
    public void setBookCategoryRepository(BookCategoryRepository bookCategoryRepository){this.bookCategoryRepository=bookCategoryRepository;}


    @Override
    public Iterable<BookCategory> listAllBookCategory() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory getBookCategoryById(Integer id)
    {
        Optional<BookCategory> opt;
        opt=bookCategoryRepository.findById(id);
        return opt.get();
    }

    @Override
    public BookCategory saveBookCategory(BookCategory bookCategory) {
         return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public void deleteBookCategory(Integer id) {
        bookCategoryRepository.deleteById(id);
    }
}
