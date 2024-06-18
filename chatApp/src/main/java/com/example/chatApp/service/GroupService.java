package com.example.chatApp.service;

import com.example.chatApp.document.Group;
import com.example.chatApp.domain.Members;
import com.example.chatApp.repository.GroupMongoRepository;
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
    private final MongoTemplate mongoTemplate;

    public void saveGroup(Group group){
        groupMongoRepository.save(group);
    }

    // 유저 아이디로 찾아서 수정
    public void saveGroupMembers(Members members){
        log.info(members.getMyUserId()+"#################################");
        List<Group> group = groupMongoRepository.findByUserId(members.getMyUserId());
        group.get(0).getMembers().add(members.getInvitedUserId());

        groupMongoRepository.save(group.get(0));

    }


    // 전체 그룹 목록
    public List<Group> findAllGroup(){
        return groupMongoRepository.findAll();
    }
    // 단일 조회
    public Group findByGroupId(String groupId){
        return groupMongoRepository.findByGroupId(groupId);
    }

}
