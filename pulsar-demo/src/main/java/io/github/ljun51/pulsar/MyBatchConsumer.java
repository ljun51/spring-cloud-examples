package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import org.apache.pulsar.client.api.Messages;
import org.springframework.stereotype.Service;

/**
 * @author john
 * @since 2022/12/23
 */
@Service
public class MyBatchConsumer {

    @PulsarConsumer(topic = "my-topic", clazz = MyMsg.class, consumerName = "my-consumer",
            subscriptionName = "my-subscription")
    public void consumeString(Messages<MyMsg> msgs) {
        msgs.forEach((msg -> {
            System.out.println(msg);
        }));
    }
}
