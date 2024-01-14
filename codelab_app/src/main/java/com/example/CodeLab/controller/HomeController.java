package com.example.CodeLab.controller;

import com.example.CodeLab.domain.entity.Member;
import com.example.CodeLab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private MemberService memberService;

    public String home(){
        return "index";
    }

    @PostMapping("/registry")
    public String registry(@RequestParam("memberName") String memberName,
                           RedirectAttributes redirectAttributes){
        try{
            Member savedMember = memberService.registry(memberName);
            redirectAttributes.addFlashAttribute("memberInfo", savedMember);
            return "redirect:/rooms";
        }
        catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/";
        }
    }
}
