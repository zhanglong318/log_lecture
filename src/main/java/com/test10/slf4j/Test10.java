package com.test10.slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test10 {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test10.class);
        logger.info("Hello World");
    }
}
