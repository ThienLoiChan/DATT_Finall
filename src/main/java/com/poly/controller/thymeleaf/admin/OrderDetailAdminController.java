package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderDetailAdminController {

    @GetMapping("admin/orderdetail")
    public String orderDetail(){
        return "admin/orderdetail";
    }
}
