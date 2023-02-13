package com.scardamone.kafka.kafka.test.project.controller;


import com.scardamone.kafka.kafka.test.project.model.Sensor;
import com.scardamone.kafka.kafka.test.project.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private KafkaService kafkaService;
    @Autowired
    public KafkaController(KafkaService kafkaService){
        this.kafkaService = kafkaService;
    }

    @PostMapping("/produceMessage")
    public void produceMessage(@RequestBody Sensor sensor){
        kafkaService.produceMessage(sensor);
    }
    @KafkaListener(topics = "displacement_transducer", groupId = "group-id")
    public void listenGroupFoo(String message) {

        System.out.println("Received Message in group foo: " + message);
    }

}
