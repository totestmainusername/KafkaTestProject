package com.scardamone.kafka.kafka.test.project.config;


import com.scardamone.kafka.kafka.test.project.common.PartitionSelector;
import com.scardamone.kafka.kafka.test.project.model.Sensor;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;


import java.util.List;
import java.util.Map;

public class KafkaCustomPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int chosenPartition;

        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();

        if (value == null) {
            chosenPartition = 0;
        }
        else if (value instanceof Sensor) {
            Sensor sensor = (Sensor) value;
            chosenPartition = new PartitionSelector().retunValue(sensor.getAssetId(), sensor.getId(),sensor.getTenantId());
        }
        else {
            chosenPartition = 0;
        }
        return  chosenPartition;

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
