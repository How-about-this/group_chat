package com.example.chatApp.repository;

import com.example.chatApp.document.Chat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
    @Tailable // 커서를 안닫고 계속 유지
    @Query("{ roomId:?0 }")
    Flux<Chat> mFindByRoomNum(String roomId);

    @Query("{ }")
    Flux<Chat> findAllBy(Pageable pageable);

}
