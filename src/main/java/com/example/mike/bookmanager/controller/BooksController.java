package com.example.mike.bookmanager.controller;

import com.example.mike.bookmanager.model.Book;
import com.example.mike.bookmanager.model.mapper.BookMapper;
import com.example.mike.bookmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
//@Validated
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
    public String getFormForAdd(@ModelAttribute("book") Book book){
        return "generalPage";
    }

    @PostMapping
    public String addBook(@ModelAttribute("book") @Valid Book book,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "generalPage";
        }
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
    public String edit(@ModelAttribute("book") @Valid Book book,
                       BindingResult bindingResult,
                       @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "generalPage";
        }
        service.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", this.service.getBookById(id));
        return "bookById";
    }
}
