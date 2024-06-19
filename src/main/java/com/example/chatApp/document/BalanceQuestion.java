package com.example.chatApp.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "balancequestion")
public class BalanceQuestion {

    @Id
    private String id;
    private String question;
    private LocalDateTime createAt;


}
