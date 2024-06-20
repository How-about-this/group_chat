package com.example.chatApp.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "chat_room")
public class ChatRoom {
    @Id
    private String id;
    private String chatName;

}
