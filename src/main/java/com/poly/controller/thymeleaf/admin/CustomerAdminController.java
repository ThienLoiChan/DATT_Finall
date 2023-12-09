package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerAdminController {
    @GetMapping("admin/customer")
    public String customer(){
        return "admin/customer";
    }
}
