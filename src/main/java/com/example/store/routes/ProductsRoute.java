package com.example.store.routes;

import com.example.store.models.Product;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class ProductsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:getProducts")
                .id("getProducts")
                .log("Vai consultar os produtos")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader("accept", constant("application/json"))
                .setHeader("Accept-Encoding", constant("gzip"))
                .log("GET >> {{fake-store-api.uri}}/products")
                .to("{{fake-store-api.uri}}/products?bridgeEndpoint=true")
                .unmarshal(new ListJacksonDataFormat(Product.class));
    }
}
