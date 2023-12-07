package com.example.CodeLab.service;

import com.example.CodeLab.domain.entity.CodeRoom;
import com.example.CodeLab.repository.CodeRoomRepository;
import com.example.CodeLab.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CodeRoomService {
    @Autowired
    private CodeRoomRepository codeRoomRepository;
    @Autowired
    private MemberRepository memberRepository;

    public List<CodeRoom> findAllCodeRoom() {
        return codeRoomRepository.findAll();
    }

    public void createRoom(String roomName, String ownerName) {
        if (!memberRepository.existsMemberByMemberName(ownerName))
            throw new RuntimeException("Member not found!");

        String roomId = UUID.randomUUID().toString();

        CodeRoom newCodeRoom = CodeRoom
                .builder()
                .roomId(roomId)
                .roomName(roomName)
                .ownerName(ownerName)
                .build();

        codeRoomRepository.save(newCodeRoom);

    }
}
