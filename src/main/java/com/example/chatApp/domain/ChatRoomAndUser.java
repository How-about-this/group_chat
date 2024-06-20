package com.example.chatApp.domain;

import com.example.chatApp.document.ChatRoom;
import com.example.chatApp.document.Group;
import com.example.chatApp.document.User;
import lombok.Data;

@Data
public class ChatRoomAndUser {
    private ChatRoom chatRoom;
    private User user;
    private Group group;
}
