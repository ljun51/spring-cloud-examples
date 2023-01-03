package io.github.ljun51.pulsar;

/**
 * @author john
 * @since 2022/12/23
 */
public class MyMsg {
    private String data;

    public MyMsg(String data) {
        this.data = data;
    }

    public MyMsg() {
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MyMsg{" +
                "data='" + data + '\'' +
                '}';
    }
}
