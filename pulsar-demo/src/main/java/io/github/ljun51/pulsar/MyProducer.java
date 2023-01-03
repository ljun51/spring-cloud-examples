package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.producer.PulsarTemplate;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author john
 * @since 2022/12/23
 */
@RestController
@Service
public class MyProducer {

    @Autowired
    private PulsarTemplate<MyMsg> producer;

    @GetMapping("/hello")
    MessageId sendHelloWorld() throws PulsarClientException {
        return producer.send("my-topic", new MyMsg("Hello world"));
    }
}
