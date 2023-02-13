package com.scardamone.kafka.kafka.test.project.Integration;


import com.scardamone.kafka.kafka.test.project.config.KafkaConsumerConfig;
import com.scardamone.kafka.kafka.test.project.model.Sensor;
import com.scardamone.kafka.kafka.test.project.service.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka
public class PartitionSelectorTest {
//    Sensor sensorPartition0 = new Sensor("3263", "DISPLACEMENT_TRANSDUCER", "2023-01-04T09:20:03.000Z", "DISPLACEMENT_TRANSDUCER_01", 41.68F, "4321", "0987");
//    Sensor sensorPartition1 = new Sensor("2263", "DISPLACEMENT_TRANSDUCER", "2023-01-04T09:20:03.000Z", "DISPLACEMENT_TRANSDUCER_01", 41.68F, "4321", "0987");
//
//    private String topic = "displacement_transducer";
//    @Autowired
//    KafkaService kafkaService;
//    @Autowired
//    EmbeddedKafkaBroker embeddedKafkaBroker = new EmbeddedKafkaBroker(2,true , topic );
//
//    @Autowired
//    KafkaConsumerConfig kafkaConsumerConfig;
//    @Test
//    public void IntegrationTestCustomPartitioner(){
//        kafkaService.produceMessage(sensorPartition0);
//        kafkaService.produceMessage(sensorPartition1);
//
//
//        kafkaService.produceMessage(sensorPartition0);
//        ConsumerRecord<String, Sensor> consumerRecord0 = KafkaTestUtils.getSingleRecord(KafkaConsumerConfig(), topic);
//        assertThat(consumerRecord0.partition()).isEqualTo(0);
//
//        kafkaService.produceMessage(sensorPartition1);
//        ConsumerRecord<String, Sensor> consumerRecord1 = KafkaTestUtils.getSingleRecord(embeddedKafkaBroker, topic);
//        assertThat(consumerRecord1.partition()).isEqualTo(1);
//    }
//

    //        @Autowired
//        private KafkaConsumerConfig consumer;
//
//    @Autowired
//    private KafkaTemplate<String, Sensor> kafkaTemplate;
//
//    @Autowired
//        private KafkaProducerConfig producer;
//
//        @Value("displacement_transducer")
//        private String topic;
//
//        @Test
//        public void givenEmbeddedKafkaBroker_whenSendingWithSimpleProducer_thenMessageReceived()
//                throws Exception {
//            String data = "Sending with our own simple KafkaProducer";
//            Sensor sensorPartition0 = new Sensor(
//                    "3263",
//                    "DISPLACEMENT_TRANSDUCER",
//                    "2023-01-04T09:20:03.000Z",
//                    "DISPLACEMENT_TRANSDUCER_01",
//                    41.68F,
//                    "4321",
//                    "0987");
//            Sensor sensorPartition1 = new Sensor(
//                    "22263",
//                    "DISPLACEMENT_TRANSDUCER",
//                    "2023-01-04T09:20:03.000Z",
//                    "DISPLACEMENT_TRANSDUCER_01",
//                    41.68F,
//                    "4321",
//                    "0987");
//            kafkaTemplate.send( "displacement_transducer", sensorPartition0);
//            KafkaTestUtils.
//
//
//            boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
//            assertTrue(messageConsumed);
//            assertThat(consumer.getPayload(), containsString(data));
//        }


}

