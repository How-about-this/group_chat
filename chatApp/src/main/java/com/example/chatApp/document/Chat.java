package com.example.chatApp.document;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "chat")
public class Chat {
    @Id
    private String id;
    private String msg;
    private String sender; // 보내는사람
    private String receiver; // 받는 사람(귓속말)
    private LocalDateTime createAt;
    private String roomId;
}
