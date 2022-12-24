package io.github.ljun51.pulsar;

import io.github.majusko.pulsar.producer.ProducerFactory;
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
}
