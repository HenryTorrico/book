package com.ucbcba.Book.repositories;


import com.ucbcba.Book.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}
