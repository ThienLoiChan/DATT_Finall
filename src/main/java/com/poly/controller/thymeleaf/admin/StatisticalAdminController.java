package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticalAdminController {
    @GetMapping("admin/statistical")
    public String statistical(){
        return "admin/statistical";
    }
}

