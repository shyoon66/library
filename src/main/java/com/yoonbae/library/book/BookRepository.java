package com.yoonbae.library.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    Book findByIsbn10OrIsbn13(String isbn10, String isbn13);
    List<Book> findByPublisher(String publisher);
    List<Book> findByPerson(String person);
}
