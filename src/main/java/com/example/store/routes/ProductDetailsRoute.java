package com.example.store.routes;

import com.example.store.models.Product;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:getProductFromId")
                .id("getProductFromId")
                .log("Vai consultar o produto ${header.productId}")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader("accept", constant("application/json"))
                .setHeader("Accept-Encoding", constant("gzip"))
                .log("GET >> {{fake-store-api.uri}}/products/${header.productId}")
                .toD("{{fake-store-api.uri}}/products/${header.productId}?bridgeEndpoint=true")
                .unmarshal(new JacksonDataFormat(Product.class));
    }
}
