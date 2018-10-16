package com.ucbcba.Book.repositories;

import com.ucbcba.Book.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
}
