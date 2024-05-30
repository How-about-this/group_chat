package com.example.chatApp.controller;


import com.example.chatApp.document.Chat;
import com.example.chatApp.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final ChatService chatService;

    // 일반 채팅
    @CrossOrigin
    @GetMapping(value = "/chat/roomNum/{roomNum}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> findByRoomNum(@PathVariable Integer roomNum){
        return chatService.findByRoomNum(roomNum);
    }

    @CrossOrigin
    @PostMapping("/chat")
    public Mono<Chat> sendMsg(@RequestBody Chat chat){
        chat.setCreateAt(LocalDateTime.now());
        return chatService.sendMsg(chat); // Object를 리턴하면 자동으로 JSON 변환(MessageConverter)
    }

    @CrossOrigin
    @GetMapping("/chat/list")
    public Flux<Chat> getChatRooms(@PageableDefault(size=5, sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
        log.info(chatService.getChatRooms(pageable).toString());
        return chatService.getChatRooms(pageable);
    }

    @CrossOrigin
    @DeleteMapping("/chat/{id}")
    public void removeMsg(@PathVariable String id){
        chatService.removeMsg(id);
    }


}
