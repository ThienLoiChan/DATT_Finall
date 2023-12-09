package com.poly.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangePasswordController {
    @GetMapping("/change-password")
    public String index() {
        return "customer/change-password";
    }
}
