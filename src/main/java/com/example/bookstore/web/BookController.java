package com.example.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping({"/", "/booklist"})
	public String bookIndex(Model model) {
		
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/addbook")
	public String addBookForm(Model model) {
		
		model.addAttribute("book", new Book());
		return "addbook";
		
	}
	
	@PostMapping("/addbook")
	public String addBookAction(Book book) {
		
		repository.save(book);
		return "redirect:/booklist";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {

		repository.deleteById(bookId);
		return "redirect:/booklist";
	
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		
		Book book = repository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book id:" + bookId));
		
		model.addAttribute("book", book);
		return "editbook";
		
	}
	
	@PostMapping("/edit/{id}")
	public String updateBook(@PathVariable("id") Long bookId, Book book) {
		
		book.setId(bookId);
		repository.save(book);
		return "redirect:/booklist";
	}
	
}
