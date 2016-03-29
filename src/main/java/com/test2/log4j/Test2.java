package com.test2.log4j;


import org.apache.log4j.Logger;

public class Test2 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Test2.class);

        if(logger.isInfoEnabled()) {
            logger.info("my log4j2 test");
        }

    }
}
