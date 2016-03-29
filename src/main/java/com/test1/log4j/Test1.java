package com.test1.log4j;


import org.apache.log4j.Logger;

public class Test1 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Test1.class);

        if(logger.isDebugEnabled()) {
            logger.debug("hello world");
        }

        logger.error("hello world");
    }
}
