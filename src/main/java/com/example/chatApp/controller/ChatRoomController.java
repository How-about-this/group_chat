package com.example.chatApp.controller;

import com.example.chatApp.document.Chat;
import com.example.chatApp.document.ChatRoom;
import com.example.chatApp.document.User;
import com.example.chatApp.domain.ChatRoomAndUser;
import com.example.chatApp.service.ChatRoomService;
import com.example.chatApp.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;


    @CrossOrigin
    @GetMapping("/chat_room")
    public ResponseEntity<List<ChatRoom>> getChatRoom(){

        log.info("채팅방 목록 불러오기");
        return ResponseEntity.ok(chatRoomService.findAllChatRoom());
    }

    @CrossOrigin
    @PostMapping("/chat_room")
    public void mkChatRoom(@RequestBody ChatRoomAndUser chatRoomAndUser){
        log.info("채팅방 생성");
        log.info(chatRoomAndUser.getChatRoom().getChatName());
        log.info(chatRoomAndUser.getGroup().getContent());
        chatRoomService.saveChatRoom(chatRoomAndUser);

    }

    @CrossOrigin
    @DeleteMapping("/chat_room")
    public void deleteChatRoom(@RequestBody User user, @RequestBody ChatRoom chatRoom){


    }


}
