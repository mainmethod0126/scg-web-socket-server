package io.github.mainmethod0126.scgwebsocketserver.domain.room.entity;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private String id;
    private String name;
    private Set<String> participantIds;

    @Builder
    public Room(String id, String name, Set<String> participantIds) {
        this.id = id;
        this.name = name;
        this.participantIds = participantIds;
    }

}
