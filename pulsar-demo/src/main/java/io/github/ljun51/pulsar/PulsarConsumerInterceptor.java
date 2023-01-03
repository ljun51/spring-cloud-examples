package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.consumer.DefaultConsumerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.springframework.stereotype.Component;

/**
 * @author john
 */
//@Component
@Slf4j
public class PulsarConsumerInterceptor extends DefaultConsumerInterceptor<MyMsg> {

    @Override
    public Message<MyMsg> beforeConsume(Consumer<MyMsg> consumer, Message<MyMsg> message) {
        log.info("todo");
        return message;
    }
}
