package com.scardamone.kafka.kafka.test.project.Integration;

import com.scardamone.kafka.kafka.test.project.config.KafkaConsumerConfig;
import com.scardamone.kafka.kafka.test.project.controller.KafkaController;
import com.scardamone.kafka.kafka.test.project.model.Sensor;
import com.scardamone.kafka.kafka.test.project.service.KafkaService;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka
public class KafkaControllerIntegrationTest {

    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Autowired
    private KafkaService kafkaService;

    @BeforeEach
    public void setUp() {
        this.embeddedKafkaBroker = new EmbeddedKafkaBroker(2, true,"displacement_transducer" );
    }

    @Test
    public void testProduceMessage() throws Exception {
        Sensor sensorPartition0 = new Sensor("3263", "DISPLACEMENT_TRANSDUCER", "2023-01-04T09:20:03.000Z", "DISPLACEMENT_TRANSDUCER_01", 41.68F, "4321", "0987");
        Sensor sensorPartition1 = new Sensor("2263", "DISPLACEMENT_TRANSDUCER", "2023-01-04T09:20:03.000Z", "DISPLACEMENT_TRANSDUCER_01", 41.68F, "4321", "0987");
        String topic = "displacement_transducer";
        String group = "group-id";

        kafkaService.produceMessage(sensorPartition0);

        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps(group, "true", embeddedKafkaBroker);
        Consumer<Object, Object> consumer = new DefaultKafkaConsumerFactory<>(consumerProps).createConsumer();
        embeddedKafkaBroker.consumeFromEmbeddedTopics(consumer, topic);

        ConsumerRecord<Object, Object> consumerRecord0 = KafkaTestUtils.getSingleRecord(consumer, topic);
        ConsumerRecord<Object, Object> consumerRecord1 = KafkaTestUtils.getSingleRecord(consumer, topic);

        assertThat(((String)consumerRecord0.value()).contains("3263"));
        assertThat(consumerRecord0.partition()).isEqualTo(0);

        assertThat(((String)consumerRecord1.value()).contains("2263"));
        assertThat(consumerRecord1.partition()).isEqualTo(1);

//        kafkaService.produceMessage(sensorPartition0);
//        ConsumerRecord<String, Sensor> consumerRecord0 = KafkaTestUtils.getSingleRecord(consumer, topic);
//        assertThat(consumerRecord0.partition()).isEqualTo(0);
//
//        kafkaService.produceMessage(sensorPartition1);
//        ConsumerRecord<String, Sensor> consumerRecord1 = KafkaTestUtils.getSingleRecord(consumer, topic);
//        assertThat(consumerRecord1.partition()).isEqualTo(1);
//
//        //assertThat(embeddedKafkaBroker.)
//        //assertThat(embeddedKafkaBroker.getTopics().contains(sensorPartition0));
//
//        //restTemplate.postForEntity("http://localhost:8080/proceMessage", sensorPartition1, Void.class);
//        //assertThat(embeddedKafkaBroker.getTopics().contains(sensor));
    }
}

