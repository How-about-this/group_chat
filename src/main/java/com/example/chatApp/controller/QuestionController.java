package com.example.chatApp.controller;

import com.example.chatApp.document.Question;
import com.example.chatApp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuestionController {
    private final QuestionService questionService;

    @CrossOrigin
    @GetMapping("/question/{roodId}")
    public ResponseEntity<Question> randomQuestion(@PathVariable String roodId){
        Question question = questionService.ranQuestion(roodId);
        log.info(question.toString());

        return ResponseEntity.ok(question);
    }
}
