package com.example.chatApp.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "question")
public class Question {

    @Id
    private String id;
    private String question;
    private LocalDateTime createdAt;
    private int index;

    public Question() {
        // 기본 생성자
    }

    public Question(String question, LocalDateTime createdAt, int index) {
        this.question = question;
        this.createdAt = createdAt;
        this.index = index;
    }
}