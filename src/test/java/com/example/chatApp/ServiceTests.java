package com.example.chatApp;


import com.example.chatApp.document.BalanceQuestion;
import com.example.chatApp.document.Group;
import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
import com.example.chatApp.repository.*;
import com.example.chatApp.service.BalanceQuestionService;
import com.example.chatApp.service.GroupService;
import com.example.chatApp.service.UserService;
import com.example.chatApp.type.Gender;
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
    private ChatRoomMongoRepository chatRoomMongoRepository;
    @Autowired
    private ChatMongoRepository chatMongoRepository;
    @Autowired
    private UserMongoRepository userMongoRepository;
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
        System.out.println(groupService.findByGroupId("667328e3c346dc12d789c100").toString());
        System.out.println("왜 아무것도 안떠");

    }
    @Test
    public void updateGroupMembers(){
        Members members = new Members("66718c33f4d2316d71f31b84","66730a98e055b465694889c4");
        groupService.saveGroupMembers(members);
    }

    @Test
    public void findAllGroup(){
        System.out.println(groupService.findAllGroup().toString());
        System.out.println(groupService.findByGroupId("667132296861822d4bfeb0a1").toString());
    }

    // 유저 삭제 테스트 코드
    @Test
    public void deleteUser(){
        userMongoRepository.deleteById("6673b874d2cf052286de26d5");
        userMongoRepository.deleteById("6673b897d2cf052286de26d6");

    }

    @Test
    public void deleteChatRoom(){
        chatRoomMongoRepository.deleteById("666ea66e7dce6c0379e419e4");
        chatRoomMongoRepository.deleteById("666ea6a17dce6c0379e419e5");
        chatRoomMongoRepository.deleteById("666ea6a87dce6c0379e419e6");
        chatRoomMongoRepository.deleteById("666ea6d37dce6c0379e419e7");
        chatRoomMongoRepository.deleteById("666ea73a7dce6c0379e419e8");
        chatRoomMongoRepository.deleteById("666eb9fcf3b9480a669206cd");
        chatRoomMongoRepository.deleteById("666ed2f4f3b9480a669206ce");
        chatRoomMongoRepository.deleteById("666eeb00f3b9480a669206d3");
        chatRoomMongoRepository.deleteById("666f68a3161b936393d1e6a1");
        chatRoomMongoRepository.deleteById("666f8b9f161b936393d1e6a2");
        chatRoomMongoRepository.deleteById("666fc64f13b30619a85c7c16");
        chatRoomMongoRepository.deleteById("66736eda2a534b4ac7f64d6a");
        chatRoomMongoRepository.deleteById("66736f1b0e4f9d75f9a161ac");
        chatRoomMongoRepository.deleteById("66736f470e4f9d75f9a161ad");
        chatRoomMongoRepository.deleteById("66736f8b0e4f9d75f9a161ae");

    }
    @Test
    public void deleteChat(){
        chatMongoRepository.deleteById("6673ab10de524e60ca632680");
        chatMongoRepository.deleteById("6673abbbde524e60ca632681");
        chatMongoRepository.deleteById("6673abbbde524e60ca632682");
        chatMongoRepository.deleteById("6673abbcde524e60ca632683");
        chatMongoRepository.deleteById("6673abbcde524e60ca632684");

        chatMongoRepository.deleteById("6673abbcde524e60ca632685");
        chatMongoRepository.deleteById("6673abbede524e60ca632686");
        chatMongoRepository.deleteById("6673b534d2cf052286de26d3");
        chatMongoRepository.deleteById("6673b536d2cf052286de26d4");


    }
    @Test
    public void updateUser(){
        User user = userMongoRepository.findById("66718c33f4d2316d71f31b84").get();
        user.getApplicants().remove("66718c33f4d2316d71f31b84");
        userMongoRepository.save(user);
    }



    @Test
    public void deleteGroup(){
        groupService.removeGroupById("6673b8bdd2cf052286de26d7");

    }

    @Test
    public void getUser(){
        userService.findUserByMemberId(1L);
    }

    @Test
    public void findMembers(){
        List<User> members = userService.findMembers("66718c33f4d2316d71f31b84");
        for(User user : members){
            System.out.println(user.toString());
        }

    }


}
