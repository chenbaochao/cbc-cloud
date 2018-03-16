package com.cbc.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by cbc on 2018/3/15.
 */
@FeignClient("consul-client")
public interface DcClient {

    @GetMapping("/discovery/client")
    String consumer();
}
