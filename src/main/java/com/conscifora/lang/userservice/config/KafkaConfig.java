package com.conscifora.lang.userservice.config;

import org.apache.kafka.clients.admin.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.*;

import java.util.*;

@Configuration
public class KafkaConfig {

    @Bean
    NewTopic createTopic() {
        return TopicBuilder.name("product-created-events-topic")
                .partitions(3)
                .replicas(1)
                .configs(Map.of("min.insync.replicas","2"))
                .build();
    }


}
