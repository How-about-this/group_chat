package com.example.chatApp.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Members {

    private String myUserId;
    private String invitedUserId;

    public Members(String myUserId, String invitedUserId) {
        this.myUserId = myUserId;
        this.invitedUserId = invitedUserId;
    }
}
