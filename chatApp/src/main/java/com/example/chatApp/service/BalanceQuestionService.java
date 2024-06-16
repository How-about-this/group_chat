package com.example.chatApp.service;

import com.example.chatApp.document.BalanceQuestion;
import com.example.chatApp.repository.BalanceQuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BalanceQuestionService {

    private final BalanceQuestionRepository balanceQuestionRepository;
    private final Random random = new Random();
    // 아이스 브레이킹 질문 목록
    public Mono<BalanceQuestion> getRandomQuestion(){
        log.info("#################################################### 안녕하세요 ##############################");
        return balanceQuestionRepository.findAll()
                .collectList() // Flux를 List로 변환
                .flatMap(list -> {
                    if (list.isEmpty()) {
                        return Mono.empty(); // 리스트가 비어있으면 빈 Mono 반환
                    }
                    int randomIndex = random.nextInt(list.size());
                    return Mono.just(list.get(randomIndex)); // 랜덤한 인덱스의 요소를 Mono로 반환
                });

    }
}
