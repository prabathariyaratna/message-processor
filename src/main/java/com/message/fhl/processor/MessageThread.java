package com.message.fhl.processor;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.message.fhl.config.ThreadContext;
import com.message.fhl.domain.HAWBMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class MessageThread implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(MessageThread.class);

    @Autowired
    private MessageExecuteProcessor messageExecuteProcessor;
    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Override
    public void run() {
        LOGGER.info("MessageThread started......");
        processMessage();
    }

    private void processMessage() {
        ThreadContext.setCustomer("jal");
        HAWBMessage hawb = messageExecuteProcessor.getMessage();
        try {
            if (hawb == null) {
                Thread.sleep(1000);
                processMessage();
            }

            Thread.sleep(10000); //simulate the message processing
            LOGGER.info("Message processed =====" + hawb.getMawbNo() + "======" + hawb.getId());
            removeEntry(hawb);
            hazelcastInstance.getLock(hawb.getMawbNo()).unlock();
            processMessage();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }

    private void removeEntry(HAWBMessage haw) {
        String customerName = ThreadContext.getCustomer();
        IMap<String, List<HAWBMessage>> map = hazelcastInstance.getMap(customerName);
        List<HAWBMessage> hawbs = map.get(haw.getMawbNo());
        hawbs.remove(haw);
        if (hawbs.isEmpty()) {
            map.remove(haw.getMawbNo());
        } else {
            map.put(haw.getMawbNo(), hawbs);
        }
    }


}