package com.example.chatApp.controller;

import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
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
        log.info("유저 컨트롤러 접근!!!");
        userService.saveUser(user);
    }

    // user검색 jpa id 기준으로
    @CrossOrigin
    @GetMapping("/user/{memberId}")
    public ResponseEntity<User> selectUserByMemberId(@PathVariable Long memberId){
        return ResponseEntity.ok(userService.findUserByMemberId(memberId));
    }

    // 외부인이 신청하기
    @CrossOrigin
    @PutMapping("/user/apply")
    public void applyUser(@RequestBody Members members){
        userService.updateUserMembers(members);
    }



}
