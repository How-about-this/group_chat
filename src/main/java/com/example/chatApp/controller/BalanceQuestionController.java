package com.example.chatApp.controller;

import com.example.chatApp.document.BalanceQuestion;
import com.example.chatApp.service.BalanceQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BalanceQuestionController {
    private final BalanceQuestionService balanceQuestionService;

    @CrossOrigin
    @GetMapping("/question")
    public Mono<BalanceQuestion> getQuestion(){
        return balanceQuestionService.getRandomQuestion();
    }
}
