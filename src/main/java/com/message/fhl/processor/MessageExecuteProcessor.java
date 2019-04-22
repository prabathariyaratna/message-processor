package com.message.fhl.processor;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.message.fhl.config.ThreadContext;
import com.message.fhl.domain.HAWBMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageExecuteProcessor {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    public HAWBMessage getMessage() {
        String customerName = ThreadContext.getCustomer();
        IMap<String, List<HAWBMessage>> map = hazelcastInstance.getMap(customerName);
        for (String mab : map.keySet()) {
            if (!hazelcastInstance.getLock(mab).isLocked()) {
                hazelcastInstance.getLock(mab).lock();
                return map.get(mab).iterator().next();
            }
        }

        return null;
    }

}