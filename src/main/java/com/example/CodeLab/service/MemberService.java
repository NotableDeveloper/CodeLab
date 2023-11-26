package com.example.CodeLab.service;

import com.example.CodeLab.domain.entity.Member;
import com.example.CodeLab.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void registry(String memberName){
        if(memberRepository.existsMemberByMemberName(memberName))
            throw new RuntimeException("Already exists member!");

        Member newMember = Member.builder().memberName(memberName).build();
        memberRepository.save(newMember);
    }

    public Member getMember(String memberName){
        if(!memberRepository.existsMemberByMemberName(memberName))
            throw new RuntimeException("Member not found!");

        return memberRepository.findByMemberName(memberName);
    }
}
