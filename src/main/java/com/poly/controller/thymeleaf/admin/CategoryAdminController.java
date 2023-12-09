package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryAdminController {
    @GetMapping("/admin/category")
    public String index() {
        return "admin/category";
    }
}
