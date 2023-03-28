package io.github.mainmethod0126.scgwebsocketserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import io.github.mainmethod0126.scgwebsocketserver.certification.WebSocketConnectCertification;
import io.github.mainmethod0126.scgwebsocketserver.handler.WebSocketHandler;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketConnectCertification webSocketConnectCertification;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketHandler(), "/websocket").setAllowedOrigins("*").addInterceptors(
                webSocketConnectCertification);
    }

}
