package com.example.chatApp;


import com.example.chatApp.document.Question;
import com.example.chatApp.document.Group;
import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
import com.example.chatApp.repository.*;
import com.example.chatApp.service.QuestionService;
import com.example.chatApp.service.GroupService;
import com.example.chatApp.service.UserService;
import com.example.chatApp.type.Status;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

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
    private QuestionMongoRepository questionMongoRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ChatMongoRepository chatMongoRepository;
    @Autowired
    private UserMongoRepository userMongoRepository;
    @Autowired
    private QuestionService balanceQuestionService;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupMongoRepository groupMongoRepository;





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
        userMongoRepository.deleteById("667464fd0686d702082e64cb");
        userMongoRepository.deleteById("66746527cf1bcf6563e73eca");

    }

    @Test
    public void deleteChatRoom(){
        chatRoomMongoRepository.deleteById("667465a9cf1bcf6563e73ecc");
    }

    @Test
    public void deleteChat(){
        chatMongoRepository.deleteById("667465f9cf1bcf6563e73ecd");
        chatMongoRepository.deleteById("6674660ecf1bcf6563e73ece");
        chatMongoRepository.deleteById("6674664dfc49f1664db1628c");
        chatMongoRepository.deleteById("6674666efc49f1664db1628d");
        chatMongoRepository.deleteById("66746672fc49f1664db1628e");
        chatMongoRepository.deleteById("66746674fc49f1664db1628f");



    }
    @Test
    public void updateUser(){
        User user = userMongoRepository.findById("66718c33f4d2316d71f31b84").get();
        user.getApplicants().remove("66718c33f4d2316d71f31b84");
        userMongoRepository.save(user);
    }



    @Test
    public void deleteGroup(){
        groupService.removeGroupById("66746587cf1bcf6563e73ecb");

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

    @Test
    public void accept(){
        Members members = new Members("6673ba57f44e075c08514250","6673bb6af44e075c08514251");
        groupService.saveGroupMembers(members);
    }

    @Test
    public void addQuestion(){
        String [] str = {
                "무한으로 먹을 수 있을 때 : 돈가스 VS 피자",
                "1년 동안 : 외모 100% VS 성격 100%",
                "다시 태어나면 : 남자 VS 여자",
                "절대로 하차가 안 되는 차: 버스 VS 지하철",
                "더 절실하게 원하는 것 : 천재적인 두뇌 VS 몸매가 주는 자신감",
                "종말의 날, 구원받을 수 있는 것은 한 가지 : 좋아하는 음식 절대 안 질림 VS 전 세계 여행 가능",
                "나 VS 차은우",
                "평생 불편하게 자기 VS 평생 맛없는 음식먹기",
                "방귀 뀔 때마다 트름 소리 나기 VS 트름 할 때마다 방귀 소리 나기",
                "전 애인과 술 한잔 하기 허락 VS 이성 친구와 1박 2일 놀러 가는거 허락",
                "전 여친(남친)의 현 애인 VS 현 여친(남친)의 전 애인",
                "잠수 이별 VS 환승 이별",
                "절친의 전 애인과 사귀기 VS 전 애인의 절친과 사귀기",
                "고양이상 VS 강아지상",
                "수갑 VS 채찍",
                "100% 확률로 1억 벌기 VS 50% 확률로 20억 받기",
                "남미새(여미새) 애인 VS 모태솔로",
                "민트초코 VS 파인애플 피자",
                "예쁜 속옷만 입는 노골반 애인 VS 구멍난 속옷 입는 골반 여신",
                "섹시한 스타일 VS 귀여운 스타일"
        };

        for (int i = 0; i <str.length ; i++) {
            Question question = new Question(str[i],LocalDateTime.now(),i);
            questionMongoRepository.save(question);
            System.out.println("저장");
        }


    }

    @Test
    public void findQuestion() {
        System.out.println(questionService.ranQuestion("66744f4af138b67ab4a252a0").toString());
    }

    @Test
    public void findChat(){
        chatMongoRepository.mFindByRoomNum("66744f4af138b67ab4a252a0");
    }

}
