package com.springboot.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sample.model.Book;
import com.springboot.sample.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public Book saveBook(Book book) {
		return repository.save(book);
	}
	
	public List<Book> saveBooks(List<Book> listOfBooks) {
		return repository.saveAll(listOfBooks);
	}
	
	public List<Book> getBooks() {
		return repository.findAll();
	}
	
	public Book getBookById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Book getBookByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteBook(int id) {
		repository.deleteById(id);
		
		return "Book with " + id +" is removed";
	}
	
	public Book updateBook(Book book) {
		Book updateBook = repository.findById(book.getId()).orElse(null);
		updateBook.setName(book.getName());
		updateBook.setAuthor(book.getAuthor());
		updateBook.setPrice(book.getPrice());
		
		return repository.save(updateBook);
		
	}
	
}
