package io.github.ljun51.websocket.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
@Controller
public class StompController {

    private Logger log = LoggerFactory.getLogger(StompController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 广播消息
     */
    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public ResponseMessage helloTopic(RequestMessage requestMessage) {
        log.info("hello：{}", requestMessage);
        return new ResponseMessage("我是广播投送消息：" + requestMessage);
    }

    /**
     * 收到消息后精准投送到单个用户
     *
     * broadcast = false 避免把消息推送到同一个帐号不同的session中
     */
    @MessageMapping("/my")
    @SendToUser(value = "/topic/my",broadcast = false)
    public ResponseMessage myTopic(RequestMessage requestMessage){
        log.info("hello：{}", requestMessage);
        return new ResponseMessage("我是精准投送消息" + requestMessage);
    }

    @GetMapping("/sendMsgByUser")
    public @ResponseBody
    Object sendMsgByUser(String token, String msg) {
        simpMessagingTemplate.convertAndSendToUser(token, "/msg", msg);
        return "success";
    }

    @GetMapping("/sendMsgByAll")
    public @ResponseBody
    Object sendMsgByAll(String msg) {
        simpMessagingTemplate.convertAndSend("/topic", msg);
        return "success";
    }

    @GetMapping("/test")
    public String test() {
        return "test-stomp.html";
    }
}
