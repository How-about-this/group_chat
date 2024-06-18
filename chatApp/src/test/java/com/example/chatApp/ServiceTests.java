package com.example.chatApp;


import com.example.chatApp.document.BalanceQuestion;
import com.example.chatApp.document.Group;
import com.example.chatApp.domain.Members;
import com.example.chatApp.repository.BalanceQuestionRepository;
import com.example.chatApp.repository.GroupMongoRepository;
import com.example.chatApp.service.BalanceQuestionService;
import com.example.chatApp.service.GroupService;
import com.example.chatApp.service.UserService;
import com.example.chatApp.type.Status;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(value = false)
@Slf4j
public class ServiceTests {
    @Autowired
    private BalanceQuestionService balanceQuestionService;
    @Autowired
    private BalanceQuestionRepository balanceQuestionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupMongoRepository groupMongoRepository;

    @Test
    public void getQuestions(){
        balanceQuestionService.getRandomQuestion();
    }

    @Test
    public void setQuestion(){
        BalanceQuestion question = new BalanceQuestion();

        question.setQuestion("잠수 이별 VS 환승 이별");
        question.setCreateAt(LocalDateTime.now());

        balanceQuestionRepository.save(question);


    }

    @Test
    public void findUser(){
        userService.findUserByName("이건");
    }

    @Test
    public void saveGroup(){
        List<String> list = new ArrayList<>();
        list.add("666fc74813b30619a85c7c17");
        Group group = new Group("파티 구합니다","오늘 밤 사냥에 나서실 분","male", Status.모집중,list);

        groupMongoRepository.save(group);
    }

    @Test
    public void findGroup(){
        System.out.println(groupMongoRepository.findByUserId("666fc74813b30619a85c7c17").get(0).getGender());
        System.out.println("왜 아무것도 안떠");

    }
    @Test
    public void updateGroupMembers(){
        Members members = new Members("666fc74813b30619a85c7c17","666fc7ae13b30619a85c7c18");
        groupService.saveGroupMembers(members);
    }

    @Test
    public void findAllGroup(){
        System.out.println(groupService.findAllGroup().toString());
        System.out.println(groupService.findByGroupId("667132296861822d4bfeb0a1").toString());
    }

    @Test
    public void updateUser(){
        Members members = new Members("666f67db161b936393d1e6a0","666fc74813b30619a85c7c17");
        userService.updateUser(members);
       //  666f67db161b936393d1e6a0  : 이건
       //  666fc74813b30619a85c7c17  : 심운보

    }

    @Test
    public void deleteGroup(){
        groupService.removeGroupById("666fd038d549e77696eb1fb4");
        groupService.removeGroupById("667132296861822d4bfeb0a1");
    }
}
