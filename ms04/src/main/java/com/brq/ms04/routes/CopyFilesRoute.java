package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CopyFilesRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from ("file:input").to("file:output");
    }
}
