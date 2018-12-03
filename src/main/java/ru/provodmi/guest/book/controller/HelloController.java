package ru.provodmi.guest.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello/")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/hello1/{name}")
    public String hello1(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello2/")
    public String hello2(@RequestParam(required = false, defaultValue = "lol") String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello3/")
    public String hello3(@RequestParam(required = true) String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello4/")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String hello4(@RequestParam(required = true) String name) {
        return "все плохо";
    }
}
