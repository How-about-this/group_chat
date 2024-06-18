package com.example.chatApp.controller;

import com.example.chatApp.document.ChatRoom;
import com.example.chatApp.document.Group;
import com.example.chatApp.domain.Members;
import com.example.chatApp.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    // 그룹 생성 기능
    @CrossOrigin
    @PostMapping("/group")
    public void setGroup(@RequestBody Group group){
        groupService.saveGroup(group);
        log.info("그룹 컨트롤러 도달");
    }

    // 멤버 초대 기능
    @CrossOrigin
    @PutMapping("/group")
    public void getGroup(@RequestBody Members members){
        groupService.saveGroupMembers(members);
        log.info("그룹 찾기 컨트롤러 도달");
    }

    @CrossOrigin
    @GetMapping("/group/list")
    public ResponseEntity<List<Group>> getAllGroup(){
        return ResponseEntity.ok(groupService.findAllGroup());
    }

    @CrossOrigin
    @GetMapping("/group/{groupId}")
    public ResponseEntity<Group> getGroupByGroupId(String groupId){
        return ResponseEntity.ok(groupService.findByGroupId(groupId));
    }





}
