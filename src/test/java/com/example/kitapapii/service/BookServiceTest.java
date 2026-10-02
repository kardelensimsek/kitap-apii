package com.example.kitapapii.service;

import com.example.kitapapii.entity.Book;
import com.example.kitapapii.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void kitapEklemeBasarili() {

        Book book = new Book();
        book.setName("Simyacı");
        book.setPrice(150);

        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.addBook(book);

        assertEquals("Simyacı", result.getName());
        assertEquals(150, result.getPrice());
    }

    @Test
    void kitapEklemeHataVerir() {

        Book book = new Book();
        book.setName("Simyacı");
        book.setPrice(150);

        when(bookRepository.save(book))
                .thenThrow(new RuntimeException("Veritabanı hatası"));

        try {
            bookService.addBook(book);
        } catch (Exception e) {
            assertEquals("Veritabanı hatası", e.getMessage());
        }
    }
}