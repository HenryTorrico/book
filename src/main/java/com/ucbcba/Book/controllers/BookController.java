package com.ucbcba.Book.controllers;

import com.ucbcba.Book.entities.Book;
import com.ucbcba.Book.services.BookCategoryServiceImpl;
import com.ucbcba.Book.services.BookService;
import com.ucbcba.Book.services.BookCategoryService;
import com.ucbcba.Book.entities.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {


    BookService bookService;
    private BookCategoryService bookCategoryService;

    @Autowired
    public void setBookService(BookService bookService){this.bookService=bookService;}


    @GetMapping(value = "/books")
    public String index( Model model) {
        List<Book> books  = (List) bookService.listAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
    @GetMapping(value = "/book/{id}")
    public String showBooks(@PathVariable Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookshow";
    }
    @GetMapping(value = "/book/new")
    public String newBook( Model model) {

        model.addAttribute("bookcategory", new Book());
        model.addAttribute("categories",bookCategoryService.listAllBookCategory());
        return "BookForm";
    }
    @PostMapping(value = "/book")
    public String create(@ModelAttribute("book") Book book, Model model) {
        bookService.saveBook(book);
        return "redirect:/books";

    }
    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories",bookCategoryService.listAllBookCategory());
        return "editbook";
    }
    @RequestMapping(value="/book/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id,Model model) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/book/like/{id}", method = RequestMethod.GET)
    public String like(@PathVariable Integer id, Model model) {
        Book book=bookService.getBookById(id);
        if(book.getLikes()>=0){
            book.setLikes(book.getLikes()+1);
        }
        bookService.saveBook(book);
    return "redirect:/books/";
    }
    @RequestMapping(value = "/book/dislike/{id}", method = RequestMethod.GET)
    public String dislike(@PathVariable Integer id, Model model) {
        Book book=bookService.getBookById(id);
        if(book.getLikes() > 0) {
            book.setLikes(book.getLikes() - 1);
            bookService.saveBook(book);
        }
        return "redirect:/books/";
    }
}
