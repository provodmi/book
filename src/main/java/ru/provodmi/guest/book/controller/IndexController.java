package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import ru.provodmi.guest.book.entity.Book;
import ru.provodmi.guest.book.service.BookService;

@Controller
public class IndexController {

    private final BookService bookService;

    @Value("${welcome.message}")
    private String message;

    @Autowired
    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public ModelAndView createPostPage() {
        ModelAndView mav = new ModelAndView("addBook");
        mav.addObject("Book", new Book());
        return mav;
    }

    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public ModelAndView allPostsPage() {
        ModelAndView mav = new ModelAndView("bookList");
        mav.addObject("books", bookService.getAll());
        return mav;
    }
}
