package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryDetailAdminController {
    @GetMapping("/admin/category/detail")
    public String index() {
        return "admin/detail-category";
    }
}
