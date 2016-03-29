package com.test6.log4j2;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test6 {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Test6.class);

        logger.entry();

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");

        logger.log(Level.INFO, "Level.Info");

        logger.exit();
    }
}
