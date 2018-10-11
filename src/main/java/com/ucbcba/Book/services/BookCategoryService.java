package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.BookCategory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookCategoryService {
    Iterable<BookCategory> listAllBookCategory();
    BookCategory getBookCategoryById(Integer id);
    BookCategory saveBookCategory(BookCategory bookCategory);
    void deleteBookCategory(Integer id);
}
