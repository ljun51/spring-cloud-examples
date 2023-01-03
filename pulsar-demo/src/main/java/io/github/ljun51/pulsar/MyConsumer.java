package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author john
 * @since 2022/12/23
 */
@Service
@Slf4j
public class MyConsumer {

    @PulsarConsumer(topic = "my-topic", clazz = MyMsg.class)
    void consume(MyMsg msg) {
        log.info(msg.getData());
    }
}
