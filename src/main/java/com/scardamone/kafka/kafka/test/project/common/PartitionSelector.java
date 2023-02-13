package com.scardamone.kafka.kafka.test.project.common;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

public class PartitionSelector {



    private Map<String, Integer> usersMap;

    public PartitionSelector(){
        usersMap= new HashMap<>();
        usersMap.put("3263DISPLACEMENT_TRANSDUCER_010987", 0);
        usersMap.put("2263DISPLACEMENT_TRANSDUCER_010987", 1);
    }


    public int retunValue(String id, String tenantId, String assetId){
     return usersMap.get(id+tenantId+assetId);
    }


}
