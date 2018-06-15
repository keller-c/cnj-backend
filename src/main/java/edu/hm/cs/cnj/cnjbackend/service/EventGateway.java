package edu.hm.cs.cnj.cnjbackend.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface EventGateway {

    @Gateway(requestChannel = "evnt-change")
    void changeEvent(VeranstaltungDto dto);

}


