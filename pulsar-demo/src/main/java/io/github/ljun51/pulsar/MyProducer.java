package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.producer.PulsarTemplate;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author john
 * @since 2022/12/23
 */
@Service
public class MyProducer {

    @Autowired
    private PulsarTemplate<MyMsg> producer;

    void sendHelloWorld() throws PulsarClientException {
        producer.send("my-topic", new MyMsg("Hello world"));
    }
}
