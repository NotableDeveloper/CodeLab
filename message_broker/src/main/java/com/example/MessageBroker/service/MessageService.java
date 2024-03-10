package com.example.MessageBroker.service;

import com.example.MessageBroker.domain.ChatMessage;
import com.example.MessageBroker.domain.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public void propagateMessage(String roomId, String content) {
        ChatMessage chatMessage = ChatMessage.builder()
                .messageType(MessageType.SOURCE)
                .roomId(roomId)
                .content(content)
                .build();

        messagingTemplate.convertAndSend(getDestinationRoom(roomId), chatMessage);
    }

    public void compile(String roomId, String content){
        /*
            To do : Code Compile
        */
        ChatMessage chatMessage = ChatMessage.builder()
                .messageType(MessageType.COMPILE)
                .roomId(roomId)
                .content("Compile")
                .build();

        messagingTemplate.convertAndSend(getDestinationRoom(roomId), chatMessage);
    }

    private String getDestinationRoom(String roomId) {
        return "/sub/rooms/" + roomId;
    }
}
