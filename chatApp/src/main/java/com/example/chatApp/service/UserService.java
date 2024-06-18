package com.example.chatApp.service;

import com.example.chatApp.document.User;
import com.example.chatApp.domain.Members;
import com.example.chatApp.repository.GroupMongoRepository;
import com.example.chatApp.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserMongoRepository userMongoRepository;

    public void saveUser(User user){
        userMongoRepository.save(user);
    }

    public List<User>  findUserByName(String name){
        return userMongoRepository.findAllByName(name);
    }

    public void updateUser(Members members){
        User user = userMongoRepository.findById(members.getMyUserId()).get();
        user.getApplicants().add(members.getInvitedUserId());
        userMongoRepository.save(user);
    }

}
