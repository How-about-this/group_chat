package com.example.chatApp.service;

import com.example.chatApp.document.Group;
import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
import com.example.chatApp.repository.GroupMongoRepository;
import com.example.chatApp.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class GroupService {
    private final GroupMongoRepository groupMongoRepository;
    private final UserMongoRepository userMongoRepository;
    public void saveGroup(Group group){

        Group grpup1 = groupMongoRepository.save(group);
        User user =userMongoRepository.findById(grpup1.getMembers().get(0)).get();
        user.setLeader(true);
        user.setParty(true);
        userMongoRepository.save(user);

    }

    // 유저 아이디로 찾아서 수정
    public void saveGroupMembers(Members members){
        log.info(members.getLeaderUserId()+"#################################");
        List<Group> group = groupMongoRepository.findByUserId(members.getLeaderUserId());
        group.get(0).getMembers().add(members.getInvitedUserId());
        User user = userMongoRepository.findById(members.getLeaderUserId()).get();
        user.getApplicants().remove(members.getInvitedUserId());
        log.info(user.toString());
        userMongoRepository.save(user);
        groupMongoRepository.save(group.get(0));

    }


    // 전체 그룹 목록
    public List<Group> findAllGroup(){
        return groupMongoRepository.findAll();
    }

    // 단일 조회
    public Group findByGroupId(String groupId){return groupMongoRepository.findById(groupId).get();}

    // 그룹 삭제
    public void removeGroupById(String id){
        groupMongoRepository.deleteById(id);
    }

}
