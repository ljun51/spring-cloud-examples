package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.annotation.PulsarConsumer;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Messages;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyBatchConsumer2 {

//    @PulsarConsumer(topic = "my-topic",
//            clazz=MyMsg.class,
//            consumerName = "my-consumer",
//            subscriptionName = "my-subscription",
//            batch = true,
//            batchAckMode = BatchAckMode.MANUAL)
    public void consumeString(Messages<MyMsg> msgs, Consumer<MyMsg> consumer) throws PulsarClientException {
        List<MessageId> ackList = new ArrayList<>();
        msgs.forEach((msg) -> {
            try {
                System.out.println(msg);
                ackList.add(msg.getMessageId());
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                consumer.negativeAcknowledge(msg);
            }
        });
        consumer.acknowledge(ackList);
    }
}
