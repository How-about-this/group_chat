package com.example.chatApp.repository;

import com.example.chatApp.document.Question;
import com.example.chatApp.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuestionMongoRepository extends MongoRepository<Question, String> {
    @Query("{ 'index' :?0 }")
    public Question findOneByIndex(Integer index);

}
