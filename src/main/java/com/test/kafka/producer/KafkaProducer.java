package com.test.kafka.producer;


import com.google.gson.Gson;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class KafkaProducer {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("metadata.broker.list", "localhost:9092");
        props.setProperty("request.required.acks", "1");
        props.setProperty("serializer.class", "kafka.serializer.StringEncoder");

        ProducerConfig producerConfig = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<>(producerConfig);

        Person person = new Person();

        person.setUsername("zhangsan");
        person.setAge(20);
        person.setMarried(true);

        String json = new Gson().toJson(person);

        KeyedMessage<String, String> keyedMessage = new KeyedMessage<>("personCreationTopic", json);
        producer.send(keyedMessage);

        producer.close();
    }
}
