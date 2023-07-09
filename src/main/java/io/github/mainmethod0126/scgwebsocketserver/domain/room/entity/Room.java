package io.github.mainmethod0126.scgwebsocketserver.domain.room.entity;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private String name;
    private String id;
    private Set<String> participantIds;

    @Builder
    public Room(String name, String id, Set<String> participantIds) {
        this.name = name;
        this.id = id;
        this.participantIds = participantIds;
    }

}
