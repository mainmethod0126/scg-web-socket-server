package io.github.mainmethod0126.scgwebsocketserver.domain.room.dto;

import io.github.mainmethod0126.scgwebsocketserver.domain.room.entity.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoomResponseDto {

    private Room room;

    @Builder
    public CreateRoomResponseDto(Room room) {
        this.room = room;
    }

}
