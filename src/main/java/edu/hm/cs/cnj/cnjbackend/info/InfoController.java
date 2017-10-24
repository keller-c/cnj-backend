package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${cnj.info.message}")
    private String message;

    @RequestMapping("/info")
    public Info info() {
        Info result = new Info();
        result.setMessage(message);
        return result;
    }
}
