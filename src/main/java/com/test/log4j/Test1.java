package com.test.log4j;


import org.apache.log4j.Logger;

public class Test1 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Test1.class);
        logger.error("hello world");
    }
}
