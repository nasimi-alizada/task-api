package com.example.taskapi.controller;

import com.example.taskapi.model.Book;
import com.example.taskapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/books")
public class BookController {
    private final BookService bookService;


    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.addbook(book);

    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Book updatedBook) {
        return bookService.getUpdatedBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBookByID(id);
    }

}
