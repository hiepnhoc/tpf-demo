package com.tpf.config;

import org.axonframework.serialization.upcasting.event.EventUpcaster;
import org.axonframework.serialization.upcasting.event.NoOpEventUpcaster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AxonConfig {
    @Bean
    EventUpcaster eventUpcaster() {
        return NoOpEventUpcaster.INSTANCE;
    }
}
