package com.example.CodeLab.controller;

import com.example.CodeLab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private MemberService memberService;

    public String home(){
        return "index";
    }

    @PostMapping("/registry")
    public String registry(@RequestParam("memberName") String memberName, Model model){
        try{
            memberService.registry(memberName);
            return "dashboard";
        }
        catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "index";
        }
    }
}
