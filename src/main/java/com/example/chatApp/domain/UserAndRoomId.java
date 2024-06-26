package com.example.chatApp.domain;

import com.example.chatApp.document.User;
import lombok.Data;

@Data
public class UserAndRoomId {
    private User user;
    private String roomId;

}
