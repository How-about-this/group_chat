package com.example.chatApp.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "group")
public class Group {
    @Id
    private String id;
    private String title;
    private String content;
    private String gender;
    private String status;
    private List<String> members = new ArrayList<>();


    public Group(String title, String content, String gender, String status, List<String> members) {
        this.title = title;
        this.content = content;
        this.gender = gender;
        this.status = status;
        this.members = members;
    }
}
