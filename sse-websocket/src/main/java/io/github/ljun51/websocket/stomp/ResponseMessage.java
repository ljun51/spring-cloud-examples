package io.github.ljun51.websocket.stomp;

/**
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
public class ResponseMessage {

    private String content;

    public ResponseMessage() {
    }

    public ResponseMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                ", content='" + content + '\'' +
                '}';
    }
}
