package com.example.FirstSpringAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FirstAIController {

    private ChatClient chatClient;


    FirstAIController(ChatClient.Builder builder) {
    this.chatClient=builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String q)
    {
        String chatResponse=chatClient.prompt(q).call().content();
        return ResponseEntity.ok(chatResponse);
    }


}
