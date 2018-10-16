package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.Book;

public interface BookService {

    Iterable<Book> listAllBooks();
    Book findBook(Integer id);
    void saveBook(Book book);
    void deleteBook(Integer id);

}
