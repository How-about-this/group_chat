package com.example.chatApp.repository;

import com.example.chatApp.document.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomMongoRepository extends MongoRepository<ChatRoom, String> {

}
