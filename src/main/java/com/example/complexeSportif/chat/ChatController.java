package com.example.complexeSportif.chat;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/chat")
@RestController
public class ChatController {


    @PostMapping("/sendMessage")
    public ResponseEntity<ChatMessage> sendMessage(
            @RequestBody ChatMessage chatMessage
    ) {

        // Handle sending message logic (you can convert and send to WebSocket clients as needed)
        return ResponseEntity.ok(chatMessage);
    }

    @PostMapping("/addUser")
    public ResponseEntity<ChatMessage> addUser(
            @RequestBody ChatMessage chatMessage
    ) {

        // Handle adding user logic (store username in session or database)
        return ResponseEntity.ok(chatMessage);
    }
}
