package com.example.chatApp.controller;


import com.example.chatApp.document.Chat;
import com.example.chatApp.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final ChatService chatService;


    // 일반 채팅
    @CrossOrigin
    @GetMapping(value = "/chat/roomId/{roomId}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> findByRoomNum(@PathVariable String roomId){
        log.info("채팅 시작");
        return chatService.findByRoomNum(roomId);
    }

    // 그냥 메세지 보내기
    @CrossOrigin
    @PostMapping("/chat")
    public Mono<Chat> sendMsg(@RequestBody Chat chat){
        chat.setCreateAt(LocalDateTime.now());
        log.info(chat.getMsg());
        return chatService.sendMsg(chat); // Object를 리턴하면 자동으로 JSON 변환(MessageConverter)
    }


    // 채팅 삭제
    @CrossOrigin
    @DeleteMapping("/chat/{id}")
    public void removeMsg(@PathVariable String id){
        chatService.removeMsg(id);
    }





}
