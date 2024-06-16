package com.example.chatApp.service;

import com.example.chatApp.document.ChatRoom;
import com.example.chatApp.repository.ChatRoomMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ChatRoomService {
    private final ChatRoomMongoRepository chatRoomMongoRepository;

    public List<ChatRoom> findAllChatRoom(){
        return chatRoomMongoRepository.findAll();
    }
    public void saveChatRoom(ChatRoom chatRoom){
        log.info("서비스 입니다");
        chatRoomMongoRepository.save(chatRoom);
    }

}
