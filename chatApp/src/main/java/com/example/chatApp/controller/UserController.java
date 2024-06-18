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

    @CrossOrigin
    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        log.info("유저 컨트롤러 접근!!!");
        if(userService.findUserByMemberId(user.getMemberId()) == null)
        userService.saveUser(user);
        else userService.updateUser(user);

    }

    @CrossOrigin
    @GetMapping("/user/{memberId}")
    public User selectUserByMemberId(@PathVariable Long memberId){
        return userService.findUserByMemberId(memberId);
    }

    // 신청하기
    @CrossOrigin
    @PutMapping("/user/apply")
    public void applyUser(Members members){
        userService.updateUserMembers(members);
    }

}
