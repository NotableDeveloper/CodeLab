package com.example.MessageBroker.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {
    private MessageType messageType;
    private String roomId;
    private String content;
}
