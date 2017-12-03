package edu.hm.cs.cnj.cnjbackend.ads;

import edu.hm.cs.cnj.cnjbackend.info.Info;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "info-service")
public interface InfoClient {

    @GetMapping("/v1/info")
    Info getInfo();
}