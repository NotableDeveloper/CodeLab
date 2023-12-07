package com.example.CodeLab.controller;


import com.example.CodeLab.domain.entity.CodeRoom;
import com.example.CodeLab.domain.entity.Member;
import com.example.CodeLab.service.CodeRoomService;
import com.example.CodeLab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class CodeRoomController {
    @Autowired private CodeRoomService codeRoomService;
    @Autowired private MemberService memberService;
    @GetMapping()
    public String rooms(Model model){
        List<CodeRoom> codeRooms = codeRoomService.findAllCodeRoom();
        model.addAttribute("codeRooms", codeRooms);
        return "dashboard";
    }

    @PostMapping("/room")
    public String create(@RequestParam("roomName") String roomName,
                         @RequestParam("memberName") String memberName,
                         RedirectAttributes redirectAttributes){
        try{
            Member findMember = memberService.getMember(memberName);
            codeRoomService.createRoom(roomName, findMember.getMemberName());
            return "redirect:/rooms";
        } catch (RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/rooms";
        }
    }
}
