package edu.hm.cs.cnj.cnjbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Configuration
public class EventConfiguration {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    IntegrationFlow updateFlow(AmqpTemplate amqpTemplate) {
        return IntegrationFlows.from("evnt-change").transform(VeranstaltungDto.class, (veranstaltung) -> {
            return "Changed: " + veranstaltung.getTitel();
        }).handle(log, "info").get();
    }

    // Missing: RabbitMQ-Code removed!
}
