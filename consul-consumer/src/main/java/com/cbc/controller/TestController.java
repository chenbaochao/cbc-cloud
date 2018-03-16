package com.cbc.controller;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cbc on 2018/3/15.
 */
@AllArgsConstructor
@RestController
public class TestController {

    private final LoadBalancerClient loadBalancerClient;

    private final RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("consul-client");
        String url = "http://"+serviceInstance.getHost() + ":" + serviceInstance.getPort()+"/discovery/client";
        System.out.println(url);
        return restTemplate.getForObject(url,String.class);
    }
}
