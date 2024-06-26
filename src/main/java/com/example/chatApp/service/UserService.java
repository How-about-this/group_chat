package com.example.chatApp.service;

import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
import com.example.chatApp.domain.UserAndRoomId;
import com.example.chatApp.repository.GroupMongoRepository;
import com.example.chatApp.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserMongoRepository userMongoRepository;

    public void saveUser(User user){
        log.info("여기인가?");
        if(userMongoRepository.findByMemberId(user.getMemberId()) == null)
        userMongoRepository.save(user);
    }

    public User findUserByName(String name){
        return userMongoRepository.findAllByName(name);
    }

    public void updateUserMembers(Members members){
        User user = userMongoRepository.findById(members.getLeaderUserId()).get();
        if(!user.getApplicants().contains(members.getInvitedUserId())) {
            user.getApplicants().add(members.getInvitedUserId());
            log.info("추가");
            userMongoRepository.save(user);
        }
        log.info("추가되지 않음");

    }

    public User findUserByMemberId(Long memberId){
        return userMongoRepository.findByMemberId(memberId);
    }
    public User findUserById(String userId){
        return userMongoRepository.findById(userId).get();
    }
    public List<User> findMembers(String id){
        User user = userMongoRepository.findById(id).get();
        List<User> members = new ArrayList<>();
        for(String membersId : user.getApplicants()){
            members.add(userMongoRepository.findById(membersId).get());
        }

        return members;
    }
    public void inUser(UserAndRoomId userAndRoomId){
        User user =  new User();
        user.setRoomId(userAndRoomId.getRoomId());
        userMongoRepository.save(user);
    }
}
