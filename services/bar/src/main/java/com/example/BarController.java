package com.example;

import com.example.model.BarMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/16/16.
 */

@RestController
public class BarController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/message")
    public BarMessage getMessage() {
        BarMessage barmsg = new BarMessage();
        barmsg.setMessage(getLocalInstanceInfo());
        return barmsg;
    }

    @RequestMapping(value = "/")
    public String home(){
        return "bar";
    }

    private String getLocalInstanceInfo(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + "@"
                + serviceInstance.getHost() + ":"
                + serviceInstance.getPort();
    }
}
