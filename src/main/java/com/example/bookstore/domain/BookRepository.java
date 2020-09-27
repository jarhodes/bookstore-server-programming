package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);

}
