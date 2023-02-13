package com.scardamone.kafka.kafka.test.project.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic customTopic(){
        return TopicBuilder.name("displacement_transducer")
                .partitions(2)
                .build();
    }

}
