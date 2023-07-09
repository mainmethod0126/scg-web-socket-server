package io.github.mainmethod0126.scgwebsocketserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import io.github.mainmethod0126.scgwebsocketserver.certification.WebSocketConnectCertification;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 구독 요청 용
        registry.enableSimpleBroker("/chat");

        // 메세지 Send 용
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // WebSocket 엔드포인트 설정
                .setAllowedOriginPatterns("*") // CORS 허용 설정
                .addInterceptors(new WebSocketConnectCertification())
                .withSockJS(); // SockJS 활성화
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new MessageValidationInterceptor());
    }

}
