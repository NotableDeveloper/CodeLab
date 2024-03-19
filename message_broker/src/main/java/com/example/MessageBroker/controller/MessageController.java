package com.example.MessageBroker.controller;

import com.example.MessageBroker.domain.ChatMessage;
import com.example.MessageBroker.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MessageController {
  @Autowired
  MessageService messageService;

  @MessageMapping("/message")
  public void receivedCodeMessage(ChatMessage message){
    messageService.propagateMessage(message.getRoomId(), message.getContent());
  }

  @MessageMapping("/compile")
  public void receivedCompileMessage(ChatMessage message){
    messageService.compile(message.getRoomId(), message.getContent());
  }
}
