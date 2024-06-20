package com.example.chatApp.document;

import com.example.chatApp.type.Status;
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
    private Status status;
    private List<String> members = new ArrayList<>();


    public Group(String title, String content, String gender, Status status, List<String> members) {
        this.title = title;
        this.content = content;
        this.gender = gender;
        this.status = status;
        this.members = members;
    }
}
