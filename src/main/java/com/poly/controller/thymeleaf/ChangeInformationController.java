package com.poly.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeInformationController {
    @GetMapping("/change-information")
    public String change(){
        return "customer/information";
    }
}
