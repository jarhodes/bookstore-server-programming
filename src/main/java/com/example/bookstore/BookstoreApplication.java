package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			catRepository.save(new Category("Satire"));
			catRepository.save(new Category("Absurdist"));
			
			log.info("save a couple of books");
			repository.save(new Book("Catch-22", 1961, "0-671-12805-1", 8.83, catRepository.findByName("Satire").get(0)));
			repository.save(new Book("American Psycho", 1991, "978-0-679-73577-9", 7.38, catRepository.findByName("Absurdist").get(0)));
			repository.save(new Book("1984", 1949, "9780141391700", 10.99, catRepository.findByName("Satire").get(0)));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
	

}
