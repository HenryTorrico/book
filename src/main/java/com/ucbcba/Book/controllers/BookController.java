package com.ucbcba.Book.controllers;

import com.ucbcba.Book.entities.Book;
import com.ucbcba.Book.entities.User;
import com.ucbcba.Book.services.BookService;
import com.ucbcba.Book.services.BookCategoryService;
import com.ucbcba.Book.entities.BookCategory;
import com.ucbcba.Book.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {


    BookService bookService;
    BookCategoryService bookCategoryService;
    UserService userService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }


    @Autowired
    public void setBookCategoryService(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/books")
    public String index( Model model) {
        List<Book> books  = (List) bookService.listAllBooks();;
        model.addAttribute("book", books);
        return "books";
    }
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model) {

        model.addAttribute("book", bookService.findBook(id));
        return "bookshow";
    }
    @RequestMapping(value = "/book/new", method = RequestMethod.GET)
    public String newBook( Model model) {
        List<BookCategory> bookCategories  = (List) bookCategoryService.listAllBookCategory();
        List<User> users  = (List) userService.listAllUsers();
        model.addAttribute("book", new Book());
        model.addAttribute("errorLikes", "");
        model.addAttribute("bookCategories", bookCategories);
        model.addAttribute("users", users);
        return "BookForm";
    }
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String create(@ModelAttribute("book") @Valid Book book,BindingResult bindingResult, Model model) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Book book = bookService.findBook(id);
        List<BookCategory> bookCategories  = (List) bookCategoryService.listAllBookCategory();
        List<User> users  = (List) userService.listAllUsers();
        model.addAttribute("book", book);
        model.addAttribute("bookCategories", bookCategories);
        model.addAttribute("users", users);
        return "BookForm";
    }
    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, Model model) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/book/like/{id}", method = RequestMethod.GET)
    public String like(@PathVariable Integer id, Model model) {
        Book book=bookService.findBook(id);
        if(book.getLikes()>=0){
            book.setLikes(book.getLikes()+1);
        }
        bookService.saveBook(book);
    return "redirect:/books/";
    }
    @RequestMapping(value = "/book/dislike/{id}", method = RequestMethod.GET)
    public String dislike(@PathVariable Integer id, Model model) {
        Book book=bookService.findBook(id);
        if(book.getLikes() > 0) {
            book.setLikes(book.getLikes() - 1);
            bookService.saveBook(book);
        }
        return "redirect:/books/";
    }
}
