package edu.hm.cs.cnj.cnjbackend.ads;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cnj-advertising-service")
public interface AdClient {

    @GetMapping(value = "/v1/ads")
    ResponseEntity<String> findAd();
}