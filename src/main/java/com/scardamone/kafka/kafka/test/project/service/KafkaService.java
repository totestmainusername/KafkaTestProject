package com.scardamone.kafka.kafka.test.project.service;

import com.scardamone.kafka.kafka.test.project.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private KafkaTemplate<String, Sensor> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, Sensor> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessage(Sensor sensor){
        kafkaTemplate.send(sensor.getSensorType().toLowerCase(), sensor);
    }
}
