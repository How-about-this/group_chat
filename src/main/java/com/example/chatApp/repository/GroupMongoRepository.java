package com.example.chatApp.repository;

import com.example.chatApp.document.Group;
import com.example.chatApp.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GroupMongoRepository extends MongoRepository<Group, String> {

    @Query("{ 'members' :?0 }")
    public List<Group> findByUserId(String userId);

    @Query("{ 'id' :?0 }")
    public Group findByGroupId(String groupId);

}
