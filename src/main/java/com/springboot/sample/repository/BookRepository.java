package com.springboot.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sample.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByName(String name);

}
