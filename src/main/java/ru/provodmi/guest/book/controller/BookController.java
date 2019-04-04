package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.provodmi.guest.book.entity.Book;
import ru.provodmi.guest.book.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(
            value = "/",
//закомментил, потому что метод только потребляет json            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String createBook(@RequestBody Book book) {
        bookService.add(book);
        return "redirect:/booklist";
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
           bookService.delete(id);
    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Book> allBooks() {
        return bookService.getAll();
    }
}
