package com.springboot.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sample.model.Book;
import com.springboot.sample.service.BookService;

@RestController
@RequestMapping(path = "/bookstore.com/v1")
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	@PostMapping("/books")
	public List<Book> addBooks(@RequestBody List<Book> book) {
		return service.saveBooks(book);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return service.getBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id) {
		return service.getBookById(id);
	}
	
	@GetMapping("/books/name/{name}")
	public Book getBookByName(@PathVariable String name) {
		return service.getBookByName(name);
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {
		return service.updateBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	public String deleteBookById(@PathVariable int id) {
		return service.deleteBook(id);
	}
}
