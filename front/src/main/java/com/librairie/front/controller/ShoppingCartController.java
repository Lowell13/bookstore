package com.librairie.front.controller;

import com.librairie.front.entity.Book;
import com.librairie.front.service.ApiRequestService;
import com.librairie.front.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ShoppingCartController {

    ShoppingCartService shoppingCartService;
    ApiRequestService apiRequestService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ApiRequestService apiRequestService) {
        this.shoppingCartService = shoppingCartService;
        this.apiRequestService = apiRequestService;
    }

    @GetMapping(value = "/cart/add/{id}")
    public RedirectView addBookToCart(@PathVariable Long id) {
        Book book = apiRequestService.getBookById(id);
        if (book != null) {
            this.shoppingCartService.addBookToCart(book);
        }
        return new RedirectView("/");
    }

    @GetMapping(value = "/cart")
    public String showCart(Model model) {
        List<Book> bookList = shoppingCartService.getBookList();
        float price = shoppingCartService.getTotalPrice();

        model.addAttribute("bookList", bookList);
        model.addAttribute("price", price);

        return "shoppingcart";
    }
}
