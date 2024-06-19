package com.example.chatApp.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Members {

    private String leaderUserId;
    private String invitedUserId;

    public Members(String leaderUserId, String invitedUserId) {
        this.leaderUserId = leaderUserId;
        this.invitedUserId = invitedUserId;
    }
}
