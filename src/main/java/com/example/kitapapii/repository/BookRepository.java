package com.example.kitapapii.repository;

import com.example.kitapapii.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}