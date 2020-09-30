package io.github.ljun51.websocket.natives;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * websocket原生方式
 *
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
@ServerEndpoint("/natives")
@Component
public class WebSocketEndPoint {

    private Logger log = LoggerFactory.getLogger(WebSocketEndPoint.class);

    @OnOpen
    public void onOpen(Session session) {
        log.info("onOpen is done, session: {}", session);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("onOpen is done, session: {}", session);
    }

    @OnMessage
    public String onMessage(String str) throws IOException {
        log.info("onOpen is done, str: {}", str);
        return "omMessage is done, " + str;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
        log.error("onError is done");
    }
}
