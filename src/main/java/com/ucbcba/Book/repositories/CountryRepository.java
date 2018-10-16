package com.ucbcba.Book.repositories;

import com.ucbcba.Book.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CountryRepository extends JpaRepository<Country,Integer>{
}
