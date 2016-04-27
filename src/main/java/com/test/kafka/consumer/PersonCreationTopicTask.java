package com.test.kafka.consumer;


import com.google.gson.Gson;
import com.test.kafka.producer.Person;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

import java.nio.charset.Charset;

public class PersonCreationTopicTask implements Runnable {

    private KafkaStream kafkaStream;

    public PersonCreationTopicTask(KafkaStream kafkaStream) {
        this.kafkaStream = kafkaStream;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> iterator = this.kafkaStream.iterator();

        while (iterator.hasNext()) {
            String jsonMessage = new String(iterator.next().message(), Charset.forName("utf-8"));
            System.out.print(jsonMessage);

            Person person = new Gson().fromJson(jsonMessage,
                    Person.class);

            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());
        }
    }


}
