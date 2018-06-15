package edu.hm.cs.cnj.cnjbackend.ads;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/adproxy")
public class AdController {

    @Autowired
    private AdClient client;

    @GetMapping
    @HystrixCommand(fallbackMethod = "defaultAd")
    ResponseEntity<String> findAd() {
        return client.findAd();
    }

    ResponseEntity<String> defaultAd() {
        return ResponseEntity.ok("Hier könnte Ihre Werbung stehen!");
    }

}
