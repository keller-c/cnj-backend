package edu.hm.cs.cnj.cnjbackend.info;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/info")
@Api
public class InfoController {

    @Autowired
    InfoProperties properties;

    @GetMapping
    @ApiOperation(value = "Show server information", response = Info.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Server reachable")
    })
    public Info getInfo(Authentication authentication) {
        Info result = new Info();
        String principal = authentication.getPrincipal().toString();
        result.setMessage(
                "Authentication: " + authentication.getAuthorities() + ", "
                        + authentication.getDetails() + ", "
                        + authentication.getCredentials()
                        + "; + Principal " + principal + "; " + properties.getMessage());
        return result;
    }
}