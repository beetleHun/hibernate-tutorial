package com.springboot.starter.hibernatetutorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/rest/books")
public class BookController {

    @GetMapping
    public Book getBook() {
        return new Book("test", "tester");
    }

}
