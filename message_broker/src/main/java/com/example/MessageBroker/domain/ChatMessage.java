package com.example.MessageBroker.domain;

import lombok.Getter;

@Getter
public class ChatMessage {
    private String roomId;
    private String message;
}
