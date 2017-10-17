package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    
    @RequestMapping("/info")
    public Info info() {
        Info result = new Info();
        result.setMessage("OK");
        return result;
    }
}
