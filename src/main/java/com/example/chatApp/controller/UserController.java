package com.example.chatApp.controller;

import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
import com.example.chatApp.domain.UserAndRoomId;
import com.example.chatApp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // user 생성 api
    @CrossOrigin
    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        log.info(user.toString());
        log.info("유저 컨트롤러 접근!!!");
        userService.saveUser(user);
    }

    // user검색 jpa id 기준으로
    @CrossOrigin
    @GetMapping("/user/{memberId}")
    public ResponseEntity<User> selectUserByMemberId(@PathVariable Long memberId){
        return ResponseEntity.ok(userService.findUserByMemberId(memberId));
    }
    @CrossOrigin
    @GetMapping("/user/members/{userId}")
    public ResponseEntity<List<User>> selectMembers(@PathVariable String userId){
        log.info("String id로 유저 찾기 컨트롤러 도달");
        return ResponseEntity.ok(userService.findMembers(userId));
    }

    @CrossOrigin
    @GetMapping("/user/get/{userId}")
    public ResponseEntity<User> selectUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    // 외부인이 신청하기
    @CrossOrigin
    @PutMapping("/user/apply")
    public void applyUser(@RequestBody Members members){
        log.info("신청컨트롤러 도달");
        log.info(members.getLeaderUserId());
        log.info(members.getInvitedUserId());
        userService.updateUserMembers(members);
    }

    // 외부인이 채팅 들어가면
    @CrossOrigin
    @PutMapping("/user/in")
    public void inUser(@RequestBody UserAndRoomId userAndRoomId){
        userService.inUser(userAndRoomId);
    }



}
