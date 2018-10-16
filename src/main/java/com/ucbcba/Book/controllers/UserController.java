package com.ucbcba.Book.controllers;

import com.ucbcba.Book.entities.Book;
import com.ucbcba.Book.entities.User;
import com.ucbcba.Book.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UserController {
    public UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "UserForm";
    }
    @RequestMapping(value = "/user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/user")
    public String save(@Valid User user, BindingResult bindingResult) {

        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {

        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "usershow";
    }



    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model) {
        User user=new User();
        user.setName("");
        user.setApellido("");
        userService.saveUser(user);
        for (Book b: userService.findUser(id).getBook()) {
            b.setUser(user);
        }
        userService.deleteUser(id);

        return "redirect:/users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = new LinkedList<>();
        for (User u: userService.listAllUsers()) {
            if (!u.getName().isEmpty() && !u.getApellido().isEmpty()) users.add(u);
        }
        model.addAttribute("users", users);
        return "users";
    }
}
