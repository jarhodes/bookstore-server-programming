package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@GetMapping({"/", "/booklist"})
	public String bookIndex(Model model) {
		
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/api/books")
	public @ResponseBody List<Book> bookListRest() {
		List<Book> bookList = (List<Book>) repository.findAll();
		return bookList;
	}
	
	@GetMapping("/api/book/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
	
	@GetMapping("/addbook")
	public String addBookForm(Model model) {
		
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepository.findAll());
		return "addbook";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		
		Book book = repository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book id:" + bookId));
		
		model.addAttribute("book", book);
		model.addAttribute("categories", catRepository.findAll());
		return "editbook";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {

		repository.deleteById(bookId);
		return "redirect:/booklist";
	
	}
	
	@PostMapping("/save")
	public String saveBook(Book book) {
		
		repository.save(book);
		return "redirect:/booklist";
		
	}
	
}