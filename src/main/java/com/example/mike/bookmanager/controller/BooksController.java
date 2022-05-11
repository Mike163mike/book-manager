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

    @GetMapping
    public String listBooks(@ModelAttribute("book") Book book, Model model) {
        List<Book> books = this.service.listBooks();
        model.addAttribute("listBooks", books);
        return "generalPage";
    }

    @GetMapping("/new")
    public String getFormForAdd(@ModelAttribute("book") Book book) {
        return "generalPage";
    }

    @PostMapping
    public String addBook(@ModelAttribute("book") Book book) {
        service.add(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String removeBook(@PathVariable("id") Integer id) {
        service.removeBook(id);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String getFormForUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("book", service.getBookById(id));
        return "editBook";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("book") Book book,
                       @PathVariable("id") Integer id) {
        service.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", this.service.getBookById(id));
        return "bookById";
    }
}
