package com.example.chatApp.document;

import com.example.chatApp.type.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String name;
    private String gender;
    private String roomId = null;
    private boolean leader = false;
    private boolean isParty = false;
    private List<String> applicants = new ArrayList<>();
}
