package com.udemy.backendninja.crudcontacts.log;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("Logger")
public class Logger {

    public void beginMethod(Log logger, String methodName, Object... parameters) {
        logger.info("Method: " + methodName + " => " + "Parameters: " + Arrays.toString(parameters));
    }

    public void endMethod(Log logger, String methodName, Object... parameters) {
        logger.info("Method: " + methodName + " => " + "Result: " + Arrays.toString(parameters));
    }

    public void requestTime(Log logger, String url, long time) {
        logger.info("Request URL: " + url + " => " + "Total Time: " + time + " ms");
    }
}
