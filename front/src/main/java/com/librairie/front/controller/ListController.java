package com.librairie.front.controller;

import com.librairie.front.entity.Book;
import com.librairie.front.service.ApiRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    private final ApiRequestService apiRequestService;

    @Autowired
    ListController(ApiRequestService apiRequestService) {
        this.apiRequestService = apiRequestService;
    }

    @GetMapping(value = "/")
    private String index(Model model) {
        List<Book> bookList = new ArrayList<>();

        bookList = apiRequestService.getAllBooks();

        model.addAttribute("bookList", bookList);
        return "index";
    }
}
