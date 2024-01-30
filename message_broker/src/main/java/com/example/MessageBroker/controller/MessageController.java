package com.example.MessageBroker.controller;

import com.example.MessageBroker.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MessageController {
  private final SimpMessageSendingOperations messagingTemplate;

  @MessageMapping("/message")
  public void message(ChatMessage message){
    messagingTemplate.convertAndSend("/sub/rooms/" + message.getRoomId(), message.getMessage());
  }

  @MessageMapping("/compile")
  public void compile(String sourceCode){
    System.out.println("received : " + sourceCode);
  }
}
