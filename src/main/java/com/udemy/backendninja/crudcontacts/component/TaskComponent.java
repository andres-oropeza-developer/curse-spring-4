package com.udemy.backendninja.crudcontacts.component;

import com.udemy.backendninja.crudcontacts.log.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "TaskComponent")
public class TaskComponent {

    public static final Log LOG_CLASS = LogFactory.getLog(TaskComponent.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @Scheduled(fixedDelay = 5000)
    public void doTask() {
        LOGGER.simpleMessage(LOG_CLASS, "TIME IS: " + new Date());
    }
}
