package com.org.springotomapping01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springotomapping01.entites.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
