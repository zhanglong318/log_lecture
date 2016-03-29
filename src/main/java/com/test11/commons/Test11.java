package com.test11.commons;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test11 {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(Test11.class);

        log.trace("Trace Info");
        log.debug("Debug info.");
        log.info("Info info");
        log.warn("Warn info");
        log.error("Error info");
        log.fatal("Fatal info");
    }

}
