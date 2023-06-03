package com.example.taskapi.service;

import com.example.taskapi.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();


    public List<Book> getAllBooks() {
        log.info("GET/books-getting all books");
        return books;
    }

    public Book getBookById(Integer id) {
        log.info("GET/books/{}- getting book with id",id);
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        log.error("book not found with id",id);
        return null;
    }


    public Book addbook(Book book) {
        log.info("POST/books- creating book {}",book);
        books.add(book);
        return book;
    }

    public Book getUpdatedBook(Integer id, Book book) {
        log.info("PUT/books/{}- updating book with id {}",id,book);
        for (Book book1 : books) {
            if (book1.getId() == id) {
                book.setAuthor(book.getAuthor());
                book1.setId(book.getId());
                return book1;
            }
        }
        return null;
    }

    public void deleteBookByID(Integer id) {
        log.info("DELETE/books/{} - Deleting book with id: {}",id);
        books.removeIf(book -> book.getId() == id);
    }
}
