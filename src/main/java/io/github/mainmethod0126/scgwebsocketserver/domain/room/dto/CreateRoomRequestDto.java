package io.github.mainmethod0126.scgwebsocketserver.domain.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateRoomRequestDto {

    private String roomName;
    private String roomPassword;
    private int maxParticipants;

    @Builder
    public CreateRoomRequestDto(String roomName, String roomPassword, int maxParticipants) {
        this.roomName = roomName;
        this.roomPassword = roomPassword;
        this.maxParticipants = maxParticipants;
    }
}
