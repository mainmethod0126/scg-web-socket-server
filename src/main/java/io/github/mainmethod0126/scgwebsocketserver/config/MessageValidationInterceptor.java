package io.github.mainmethod0126.scgwebsocketserver.config;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import io.github.mainmethod0126.scgwebsocketserver.domain.room.service.RoomService;

public class MessageValidationInterceptor implements ChannelInterceptor {

    private final RoomService roomService;

    @Override
    @Nullable
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        // 메시지 필터링 및 처리 로직 수행
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.SEND.equals(accessor.getCommand())) {
            accessor.getDestination();
        }

        return message;
    }

    private boolean isExistChatRoom(String roomId) {

    }

}
