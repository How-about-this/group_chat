package com.example.chatApp.service;

import com.example.chatApp.document.Chat;
import com.example.chatApp.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    // 단체 채팅
    public Flux<Chat> findByRoomNum(int roomNum){
        return chatRepository.mFindByRoomNum(roomNum);
    }

    // 채팅 메시지 보내기
    public Mono<Chat> sendMsg(Chat chat){
        chat.setCreateAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    public Flux<Chat> getChatRooms(Pageable pageable) {
        return chatRepository.findAllBy(pageable);
    }

    public void removeMsg(String id){
        chatRepository.deleteById(id);
    }

}
