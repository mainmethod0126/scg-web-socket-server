package io.github.mainmethod0126.scgwebsocketserver.domain.room.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private String name;
    private String id;

    @Builder
    public Room(String name, String id) {
        this.name = name;
        this.id = id;
    }

}
