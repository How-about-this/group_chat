package com.example.chatApp.service;

import com.example.chatApp.document.ChatRoom;
import com.example.chatApp.document.User;
import com.example.chatApp.repository.ChatRoomMongoRepository;
import com.example.chatApp.repository.UserMongoRepository;
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
    private final UserMongoRepository userMongoRepository;
    public List<ChatRoom> findAllChatRoom(){
        return chatRoomMongoRepository.findAll();
    }
    public void saveChatRoom(ChatRoom chatRoom, User user){
        log.info("서비스 입니다");
        ChatRoom room = chatRoomMongoRepository.save(chatRoom);
        user.setRoomId(room.getId());
        userMongoRepository.save(user);

    }

    public void removeChatRoom(User user, ChatRoom chatRoom){

        if(user.isParty() && user.isLeader()){

            chatRoomMongoRepository.delete(chatRoom);
            userMongoRepository.delete(user);

        }


    }

}
