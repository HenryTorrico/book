package com.ucbcba.Book;

import com.ucbcba.Book.controllers.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication//(scanBasePackages={"com.ucbcba.Book.services"})
//@ComponentScan(basePackageClasses= BookController.class)

public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
}
