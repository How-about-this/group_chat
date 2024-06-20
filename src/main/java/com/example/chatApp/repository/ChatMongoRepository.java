package com.example.chatApp.repository;

import com.example.chatApp.document.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatMongoRepository extends MongoRepository<Chat, String> {
    @Query("{chatRoom.roomNum:?0}")
    List<Chat> mFindByRoomNum(Integer roomNum);

    @Query("{ roomId:?0 }")
    Chat mFindByRoomNum(String roomId);
}
