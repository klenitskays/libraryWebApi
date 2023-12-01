package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.BookDTO;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;

    public Book create(BookDTO dto) {
        LocalDate borrowedTime = dto.getBorrowedTime();
        LocalDate returnTime = borrowedTime != null ? borrowedTime.plusDays(14) : null;
        Book book = Book.builder()
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .genre(dto.getGenre())
                .author(dto.getAuthor())
                .borrowedTime(dto.getBorrowedTime())
                .returnTime(returnTime)
                .build();
        return bookRepository.save(book);
    }

    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public Book readById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book readByIsbn(Long isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    public List<Book> getAvailableBooks() {
        return bookRepository.findByBorrowedTimeIsNull();
    }
    public Book update(BookDTO dto, Long id, LocalDate borrowedTime) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setIsbn(dto.getIsbn());
            book.setTitle(dto.getTitle());
            book.setGenre(dto.getGenre());
            book.setAuthor(dto.getAuthor());
            return bookRepository.save(book);
        }
        return null;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
