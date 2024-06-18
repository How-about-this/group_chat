package com.example.chatApp.controller;

import com.example.chatApp.document.Chat;
import com.example.chatApp.document.ChatRoom;
import com.example.chatApp.document.User;
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
        return ResponseEntity.ok(chatRoomService.findAllChatRoom());
    }

    @CrossOrigin
    @PostMapping("/chat_room")
    public void mkChatRoom(@RequestBody ChatRoom chatRoom, User user){
        log.info("채팅방 생성");
        chatRoomService.saveChatRoom(chatRoom,user);

    }


}
