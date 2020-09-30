package io.github.ljun51.websocket.stomp;

/**
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
public class RequestMessage {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestMessage{" +
                "name='" + name + '\'' +
                '}';
    }
}
