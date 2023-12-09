package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailAdminController {

    @GetMapping("admin/detail")
    public String detail(){
        return "admin/detail";
    }
}
