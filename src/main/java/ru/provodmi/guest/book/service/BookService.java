package ru.provodmi.guest.book.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.provodmi.guest.book.entity.Book;
import ru.provodmi.guest.book.repository.BookRepository;

import java.util.List;

@Service
@Slf4j
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void delete(Long id) {
        log.info("DEL BOOK : {}", id);
        bookRepository.delete(id);
    }

    public Book add(Book book) {
        log.info("ADD BOOK : {}", book.getAuthor() + " " + book.getTitle());
        bookRepository.add(book);
        return book;
    }

    public List<Book> getAll() {
        log.info("GET ALL BOOKS");
        return bookRepository.getAllBooks();
    }
}
