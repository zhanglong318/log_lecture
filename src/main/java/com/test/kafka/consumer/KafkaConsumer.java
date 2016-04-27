package com.test.kafka.consumer;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.consumer.Consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaConsumer {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("zookeeper.connect", "localhost:2181");
        props.put("auto.commit.interval.ms", "5000");
        props.put("zookeeper.session.timeout.ms", "6000");
        props.put("group.id", "myGroup");

        ConsumerConfig consumerConfig =  new ConsumerConfig(props);

        ConsumerConnector consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> topicMap = new HashMap<>();
        topicMap.put("personCreationTopic", 1);

        Map<String, List<KafkaStream<byte[], byte[]>>> streamMap = consumerConnector.createMessageStreams(topicMap);
        KafkaStream<byte[], byte[]> kafkaStream = streamMap.get("personCreationTopic").get(0);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new PersonCreationTopicTask(kafkaStream));
    }
}
