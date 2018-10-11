package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.Book;
import com.ucbcba.Book.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    public BookRepository bookRepository;


    @Autowired
    public void setBookRepository(BookRepository bookRepository){this.bookRepository=bookRepository;}

    @Override
    public Iterable<Book> listAllBooks(){return bookRepository.findAll();}
    @Override
    public Book getBookById(Integer id)
    {
        Optional<Book> opt;
        opt=bookRepository.findById(id);
        return opt.get();
    }
    @Override
    public void saveBook(Book book)
    {
        bookRepository.save(book);
    }
    @Override
    public void deleteBook(Integer id)
    {
        bookRepository.deleteById(id);
    }
}
