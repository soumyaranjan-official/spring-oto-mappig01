package com.org.springotomapping01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.org.springotomapping01.dao.BookRepository;
import com.org.springotomapping01.entites.Book;

@Component
public class BookServices {
	@Autowired
	BookRepository bookRepository;

	public ResponseEntity<List<Book>> saveAllBooks(List<Book> book) {

		List<Book> list = bookRepository.saveAll(book);
		return new ResponseEntity<List<Book>>(list, HttpStatus.CREATED);

	}
	public ResponseEntity<Book> saveBooks(Book book) {

		 Book save = bookRepository.save(book);
		return new ResponseEntity<Book>(save, HttpStatus.CREATED);

	}
	
	public ResponseEntity<List<Book>> getAllBook(){
		List<Book> list = bookRepository.findAll();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	public ResponseEntity<Book> getBookById(int id){
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isPresent()) {
			return new ResponseEntity<Book>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Book> updateBookById(int id,Book book){
			Optional<Book> optional = bookRepository.findById(id);
			if(optional.isPresent()) {
				book.setId(id);
				
				Book save = bookRepository.save(book);
				return new ResponseEntity<Book>(save, HttpStatus.CREATED);
			}
			
		return 	new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Book> deleteBookById(int id)
	{
		
		Optional<Book> optional = bookRepository.findById(id);
			if(optional.isPresent()) {
				bookRepository.deleteById(id);
				return new ResponseEntity<Book>(optional.get(), HttpStatus.OK);
			}
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		
	}
}
