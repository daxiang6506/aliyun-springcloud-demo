package com.example;

import com.example.model.FooMessage;
import com.example.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.FooApplication.KEY;

/**
 * Created by libin on 3/15/16.
 */

@RestController
public class FooController {

    private static final Logger log = LoggerFactory.getLogger(FooController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private InfoRepository infoRepository;

    @RequestMapping("/message")
    public FooMessage getMessage(){
        FooMessage foomsg = new FooMessage();
        foomsg.setName(getLocalInstanceInfo());
        String composedMessage =  getInfoFromDatabase();
        foomsg.setMessage(composedMessage);
        return foomsg;
    }

    private String getLocalInstanceInfo(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + ":" + serviceInstance.getHost() +
                ":" + serviceInstance.getPort();
    }

    private String getInfoFromDatabase(){
        List<Info> infoList = infoRepository.findByName(KEY);
        for(Info info : infoRepository.findByName(KEY)) {
            return info.toString();
        }
        return "(no database info)";
    }
}
