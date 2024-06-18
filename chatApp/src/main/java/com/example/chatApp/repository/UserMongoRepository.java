package com.example.chatApp.repository;

import com.example.chatApp.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserMongoRepository extends MongoRepository<User, String> {

    @Query("{ 'name' :?0 }")
    public List<User> findAllByName(String name);
}
