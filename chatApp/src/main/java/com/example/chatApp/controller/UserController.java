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
        log.info(user.getName());
        log.info(user.getGender().toString());
        userService.saveUser(user);

    }


    // 신청하기
    @CrossOrigin
    @PutMapping("/user/apply")
    public void applyUser(Members members){
        userService.updateUser(members);
    }

}
