package com.example.chatApp.repository;

import com.example.chatApp.document.BalanceQuestion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BalanceQuestionRepository extends ReactiveMongoRepository<BalanceQuestion, String> {

}
