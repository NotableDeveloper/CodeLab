package com.example.MessageBroker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MessageController {
  private final SimpMessageSendingOperations messagingTemplate;

  @MessageMapping("/message")
  public void message(String message){
    System.out.println("Msg : " + message);
  }
}
