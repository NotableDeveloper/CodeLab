package com.example.CodeLab.controller;


import com.example.CodeLab.domain.entity.CodeRoom;
import com.example.CodeLab.domain.entity.Member;
import com.example.CodeLab.service.CodeRoomService;
import com.example.CodeLab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class CodeRoomController {
    @Autowired private CodeRoomService codeRoomService;
    @Autowired private MemberService memberService;
    @GetMapping
    @ResponseBody
    public List<CodeRoom> rooms(){
        return codeRoomService.findAllCodeRoom();
    }

    @PostMapping("/room")
    public String create(@RequestParam("roomName") String roomName,
                         @RequestParam("memberName") String memberName,
                         Model model){
        try{
            Member findMember = memberService.getMember(memberName);
            codeRoomService.createRoom(roomName, findMember.getMemberName());
            return "dashboard";
        } catch (RuntimeException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "dashboard";
        }
    }
}
