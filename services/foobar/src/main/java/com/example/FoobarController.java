package com.example;

import com.example.model.BarMessage;
import com.example.model.FooMessage;
import com.example.model.FoobarMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by libin on 3/16/16.
 */

@RestController
public class FoobarController {

    private static final Logger log = LoggerFactory.getLogger(FoobarController.class);

    private static final String FOO_SERVICE_NAME = "foo";
    private static final String BAR_SERVICE_NAME = "bar";

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping("/message")
    FoobarMessage getMessage(){
        BarMessage bar = getMessageFromBarService();
        FooMessage foo = getMessageFromFooService();
        FoobarMessage foobar = new FoobarMessage();
        foobar.setBar(bar);
        foobar.setFoo(foo);

        log.debug("Result foobar message: {}.",foobar);
        return foobar;
    }

    @RequestMapping(value = "/")
    String home(){
        return "acs sample";
    }

    private BarMessage getMessageFromBarService(){
        BarMessage bar = restTemplate.getForObject("http://bar/message", BarMessage.class);
        log.debug("From bar service : {}.", bar);
        return bar;
    }

    private FooMessage getMessageFromFooService(){
        FooMessage foo = restTemplate.getForObject("http://foo/message", FooMessage.class);
        log.debug("From foo service : {}.", foo);
        return foo;
    }

}
