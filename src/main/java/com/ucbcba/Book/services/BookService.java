package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface BookService {

    Iterable<Book>  listAllBooks();
    Book getBookById(Integer id);
    void saveBook(Book book);
    void deleteBook(Integer id);
}
