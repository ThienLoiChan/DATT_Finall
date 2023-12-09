package com.poly.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {
    @GetMapping("/shopping-cart")
    public String shoppingCart() {
        return "customer/shoppingcart";
    }
}
