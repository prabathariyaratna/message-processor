package com.message.fhl.config;

import com.hazelcast.core.HazelcastInstance;
import com.message.fhl.processor.MessageThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LogManager.getLogger(StartupApplicationListener.class);
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private MessageThread messageThread;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("Initialization listener start ");
        threadPoolTaskExecutor.submit(messageThread);
        threadPoolTaskExecutor.submit(messageThread);
    }

}