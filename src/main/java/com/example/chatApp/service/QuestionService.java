package com.example.chatApp.service;

import com.example.chatApp.document.Question;
import com.example.chatApp.repository.QuestionMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    private final QuestionMongoRepository questionMongoRepository;
    private final Random random = new Random();

    public Question ranQuestion(){
        log.info("서비스 들어옴");
        int randomIntBound = random.nextInt(19);
        return questionMongoRepository.findOneByIndex(randomIntBound);
    }

}
