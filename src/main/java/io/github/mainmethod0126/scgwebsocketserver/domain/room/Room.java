package io.github.mainmethod0126.scgwebsocketserver.domain.room;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private String id;
    private int maxChatParticipants;
    private int minChatParticipants;
    private String title;
    private String description;
    private String password;
    private String passwordRequired;
    private String hostId;
    private Date createDate;

}
