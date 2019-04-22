package com.message.fhl.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.message.fhl.config.ThreadContext;
import com.message.fhl.domain.FHLMessage;
import com.message.fhl.domain.HAWBMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MessageService {

    @Autowired
    private HazelcastInstance hazelcastInstance;


    public void save(FHLMessage message) throws Exception {
        String customerName = ThreadContext.getCustomer();
        IMap<String, List<HAWBMessage>> map = hazelcastInstance.getMap(customerName);

        if (map.containsKey(message.getMawbNo())) {
            map.get(message.getMawbNo()).addAll(message.getHawbs());
        }

        map.put(message.getMawbNo(), message.getHawbs());

    }


}
