package com.example.chatApp.controller;

import com.example.chatApp.document.Group;
import com.example.chatApp.domain.Members;
import com.example.chatApp.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 파티장이 수락 기능
    @CrossOrigin
    @PutMapping("/group")
    public void getGroup(@RequestBody Members members){
        groupService.saveGroupMembers(members);
        log.info("그룹 찾기 컨트롤러 도달");
    }

    // 그룹 리스트
    @CrossOrigin
    @GetMapping("/group/list")
    public ResponseEntity<List<Group>> getAllGroup(){
        log.info("그룹 리스트 도달");
        return ResponseEntity.ok(groupService.findAllGroup());
    }


    // 그룹 상세보기
    @CrossOrigin
    @GetMapping("/group/{groupId}")
    public ResponseEntity<Group> getGroupByGroupId(@PathVariable String groupId){

        log.info("그룹 상세보기 도달");
        log.info(groupId);

        log.info("그룹 상세보기 실행");

        return ResponseEntity.ok(groupService.findByGroupId(groupId));
    }





}
