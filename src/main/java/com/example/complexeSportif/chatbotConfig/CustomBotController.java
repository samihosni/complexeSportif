package com.example.complexeSportif.chatbotConfig;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class CustomBotController {


    private String model = "gpt-3.5-turbo";
    private String apiURL = "https://api.openai.com/v1/chat/completions";

    @Autowired
    private RestTemplate template;




    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
            ChatGPTRequest request = new ChatGPTRequest(model, prompt);
            ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
            return chatGptResponse.getChoices().get(0).getMessage().getContent();

    }
}
