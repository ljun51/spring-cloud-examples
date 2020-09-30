package io.github.ljun51.websocket.spring;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

/**
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
public class BinaryHandler extends BinaryWebSocketHandler {

    @Override
    public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
    }
}
