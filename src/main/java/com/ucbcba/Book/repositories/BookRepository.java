package com.ucbcba.Book.repositories;

import com.ucbcba.Book.entities.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends CrudRepository<Book,Integer> {
}
