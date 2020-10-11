package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRepository.findByTitle("American Psycho");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getIsbn()).isEqualTo("978-0-679-73577-9");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Lord of the Flies", 1960, "12345678900987654321", 9.99, catRepository.findByName("Absurdist").get(0));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = bookRepository.findByTitle("Catch-22");
		Book catch22 = books.get(0);
		bookRepository.delete(catch22);
		List<Book> afterDelete = bookRepository.findByTitle("Catch-22");
		assertThat(afterDelete).hasSize(0);
		
	}
	
}
