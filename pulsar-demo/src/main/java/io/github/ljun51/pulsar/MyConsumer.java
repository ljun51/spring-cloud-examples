package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import org.springframework.stereotype.Service;

/**
 * @author john
 * @since 2022/12/23
 */
@Service
public class MyConsumer {

    @PulsarConsumer(topic = "my-topic", clazz = MyMsg.class)
    void consume(MyMsg msg) {
        System.out.println(msg.getData());
    }
}
