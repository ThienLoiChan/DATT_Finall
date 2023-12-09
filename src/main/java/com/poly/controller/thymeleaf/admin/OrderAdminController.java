package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderAdminController {

    @GetMapping("admin/order")
    public String order(){
        return "admin/order";
    }
}
