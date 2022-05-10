package com.example.mike.bookmanager.controller;

import com.example.mike.bookmanager.model.dto.BookAddDto;
import com.example.mike.bookmanager.model.dto.BookDto;
import com.example.mike.bookmanager.model.mapper.BookMapper;
import com.example.mike.bookmanager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService service;
    private final BookMapper mapper;


    public BookController(BookService service, BookMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("book", new BookDto());
        List<BookDto> bookDtoList = this.service.listBooks().stream()
                .map(mapper::mapToBookDto)
                .collect(Collectors.toList());
        model.addAttribute("listBooks", bookDtoList);
        return "books";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") BookAddDto bookAddDto) {
        service.add(mapper.map(bookAddDto));
        return "redirect:/books";
    }

    @DeleteMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Integer id) {
        service.removeBook(id);
        return "redirect:/books";
    }

    @PutMapping("/edit{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", this.service.getBookById(id));
        model.addAttribute("listBooks", this.service.listBooks());
        return "books";
    }

    @GetMapping("/bookId")
    public String getBookById(@RequestParam(name = "id", defaultValue = "1") Integer id, Model model) {
        model.addAttribute("book", this.service.getBookById(id));
        return "bookById";
    }
}
