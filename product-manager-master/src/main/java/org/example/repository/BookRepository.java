package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(Long isbn);
    @Query("SELECT p FROM Book p WHERE p.borrowedTime IS NULL")
    List<Book> findByBorrowedTimeIsNull();

}
