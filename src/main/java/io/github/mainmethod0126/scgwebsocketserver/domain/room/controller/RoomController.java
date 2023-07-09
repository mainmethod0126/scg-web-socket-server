package io.github.mainmethod0126.scgwebsocketserver.domain.room.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.mainmethod0126.scgwebsocketserver.domain.room.dto.CreateRoomRequestDto;
import io.github.mainmethod0126.scgwebsocketserver.domain.room.dto.CreateRoomResponseDto;
import io.github.mainmethod0126.scgwebsocketserver.domain.room.entity.Room;

@RestController
public class RoomController {

    private Map<String, CreateRoomRequestDto> chatRooms = new HashMap<>();

    @PostMapping
    public ResponseEntity<CreateRoomResponseDto> createRoom(@RequestBody CreateRoomRequestDto createRoomRequestDto) {

        chatRooms.put(createRoomRequestDto.getRoomName(), createRoomRequestDto);

        return ResponseEntity.ok(CreateRoomResponseDto.builder()
                .room(Room.builder().id("test").name(createRoomRequestDto.getRoomName()).build()).build());
    }

    @MessageMapping("/chat/{roomId}") // 클라이언트에서 '/chat.sendMessage'로 메시지 전송 요청을 보내면 이 핸들러가 호출됨
    @SendTo("/chat/{roomId}") // '/topic/public'으로 메시지 전송
    public String sendMessage(String chatMessage) {
        return chatMessage;
    }

}
