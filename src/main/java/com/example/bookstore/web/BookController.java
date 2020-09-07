package com.example.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookstore.domain.Book;

@Controller
public class BookController {
	
	private List<Book> bookList = new ArrayList<Book>();
	
	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("title", "Bookstore");
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookList);
		
		return "index";
	}

	@PostMapping("/index")
	public String addBook(@ModelAttribute Book book, Model model) {
		
		model.addAttribute("book", book);
		bookList.add(book);
		
		return "redirect:/index";
	}
	
}
