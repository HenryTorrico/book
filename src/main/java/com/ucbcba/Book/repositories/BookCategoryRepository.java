package com.ucbcba.Book.repositories;

import com.ucbcba.Book.entities.BookCategory;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookCategoryRepository extends CrudRepository<BookCategory,Integer> {
}
