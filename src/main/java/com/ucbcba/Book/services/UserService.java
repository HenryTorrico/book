package com.ucbcba.Book.services;

import com.ucbcba.Book.entities.User;

public interface UserService {

    Iterable<User> listAllUsers();
    User findUser(Integer id);
    void saveUser(User user);
    void deleteUser(Integer id);
}
