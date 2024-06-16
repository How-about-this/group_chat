package com.example.chatApp;


import com.example.chatApp.document.BalanceQuestion;
import com.example.chatApp.repository.BalanceQuestionRepository;
import com.example.chatApp.service.BalanceQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {
    @Autowired
    private BalanceQuestionService balanceQuestionService;
    @Autowired
    private BalanceQuestionRepository balanceQuestionRepository;

    @Test
    public void getQuestions(){
        balanceQuestionService.getRandomQuestion();
    }

    @Test
    public void setQuestion(){
        BalanceQuestion question = new BalanceQuestion();

        question.setQuestion("잠수 이별 VS 환승 이별");
        question.setCreateAt(LocalDateTime.now());

        balanceQuestionRepository.save(question);


    }
}
