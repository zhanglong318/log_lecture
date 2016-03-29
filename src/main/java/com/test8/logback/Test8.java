package com.test8.logback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test8 {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Test8.class);

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

    }
}
