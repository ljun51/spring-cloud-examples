package io.github.ljun51.websocket.spring;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
public class TextHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {

    }
}
