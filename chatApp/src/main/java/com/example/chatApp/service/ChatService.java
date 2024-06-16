package com.example.chatApp.service;

import com.example.chatApp.document.Chat;
import com.example.chatApp.repository.ChatMongoRepository;
import com.example.chatApp.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMongoRepository chatMongoRepository;

    // 단체 채팅
    public Flux<Chat> findByRoomNum(String roomId) {
        return chatRepository.mFindByRoomNum(roomId);
    }

    // 채팅 메시지 보내기
    public Mono<Chat> sendMsg(Chat chat){
        return chatRepository.save(chat);
    }

    //  채팅 리스트 보여주기
    public Page<Chat> getChatRooms(Pageable pageable) {
        return (Page<Chat>) chatMongoRepository.findAll(pageable);
    }

    // 채팅 삭제
    public void removeMsg(String id){
        chatRepository.deleteById(id);
    }



}
