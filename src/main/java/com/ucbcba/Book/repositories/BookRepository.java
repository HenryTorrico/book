package com.ucbcba.Book.repositories;


import com.ucbcba.Book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

}
