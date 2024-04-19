package com.org.springotomapping01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springotomapping01.entites.Book;
import com.org.springotomapping01.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookRestContriller {
	
	@Autowired
	BookServices bookService;
		
	@PostMapping("/saveAll")
	public ResponseEntity<List<Book>> saveAll(@RequestBody List<Book> book){
		return bookService.saveAllBooks(book);
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return bookService.saveBooks(book);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id)
	{
		return bookService.getBookById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBook()
	{
		return bookService.getAllBook();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable int id,@RequestBody Book book)
	{
		return bookService.updateBookById(id, book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable int id){
		return bookService.deleteBookById(id);
	}
}
