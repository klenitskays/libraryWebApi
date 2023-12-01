package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.BookDTO;
import org.example.entity.Book;
import org.example.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO dto) {
        Book book = libraryService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> readAll() {
        List<Book> books = libraryService.readAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Book> readById(@PathVariable Long id) {
        Book book = libraryService.readById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> readByIsbn(@PathVariable Long isbn) {
        Book book = libraryService.readByIsbn(isbn);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        List<Book> availableBooks = libraryService.getAvailableBooks();
        return ResponseEntity.ok(availableBooks);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Book> update(
            @RequestBody BookDTO dto,
            @PathVariable Long id,
            @RequestParam(required = false) LocalDate borrowedTime
    ) {
        Book updatedBook = libraryService.update(dto, id, borrowedTime);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}