package com.example.mike.bookmanager.controller;

import com.example.mike.bookmanager.model.Book;
import com.example.mike.bookmanager.model.mapper.BookMapper;
import com.example.mike.bookmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService service;
    private final BookMapper mapper;


    public BooksController(BookService service, BookMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks() {
//        return ResponseEntity.ok(service.listBooks());
//    }

    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = this.service.listBooks(); //.stream()
        model.addAttribute("listBooks", books);
        return "/generalPage";
    }

//    @PostMapping
//    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
//        service.add(book);
//        return ResponseEntity.ok(book);
//    }


    @PostMapping
    public String addBook(@RequestParam("bookTitle") String bookTitle,
                          @RequestParam("bookAuthor") String bookAuthor,
                          @RequestParam("bookPrice") Integer bookPrice,
                          Model model) {
        Book newBook = new Book(bookTitle, bookAuthor, bookPrice);
        service.add(newBook);
        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("bookAuthor", bookAuthor);
        model.addAttribute("bookPrice", bookPrice);
        return "/generalPage";
    }

    @DeleteMapping("/{id}")
    public String removeBook(@PathVariable("id") Integer id,
                             Model model) {
        service.removeBook(id);
        List<Book> books = this.service.listBooks(); //.stream()
        model.addAttribute("listBooks", books);
        return "/generalPage";
    }

    @PutMapping("/edit{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", this.service.getBookById(id));
        model.addAttribute("listBooks", this.service.listBooks());
        return "generalPage";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", this.service.getBookById(id));
        return "bookById";
    }
}
