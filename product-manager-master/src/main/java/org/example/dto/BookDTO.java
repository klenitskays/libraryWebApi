package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
private Long id;
    private Long isbn;
    private String title;
    private String genre;
    private String author;
    private LocalDate borrowedTime;
    private LocalDate returnTime;
    private boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDate borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public LocalDate getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDate returnTime) {
        this.returnTime = returnTime;
    }
}