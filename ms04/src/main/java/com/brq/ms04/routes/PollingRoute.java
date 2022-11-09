package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PollingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:polling?period=5000")
                .to("https://economia.awesomeapi.com.br/json/last/USD-BRL")
                .log("${body}");    }
}
