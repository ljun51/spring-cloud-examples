package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.producer.ProducerFactory;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author john
 * @since 2022/12/23
 */
@Configuration
public class ProducerConfiguration {

    @Bean
    public ProducerFactory producerFactory() {
        return new ProducerFactory()
                .addProducer("my-topic", MyMsg.class)
                .addProducer("other-topic", String.class);
    }

    @Bean
    @SneakyThrows
    public PulsarClient pulsarClient() {
        return PulsarClient.builder()
        .serviceUrl("pulsar://localhost:6650")
        .build();
    }

    @Bean
    @SneakyThrows
    public Producer<byte[]> producerClient() {
        return pulsarClient().newProducer()
        .topic("my-topic")
        .producerName(null)
        .sendTimeout(30, TimeUnit.SECONDS)
        .blockIfQueueFull(false)
        .maxPendingMessages(1000)
        .create();
    }
}
