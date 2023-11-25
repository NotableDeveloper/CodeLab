package com.example.CodeLab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    public String home(){
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, Model model){
        model.addAttribute("errorMessage", "message!");
        return "index";
    }
}
