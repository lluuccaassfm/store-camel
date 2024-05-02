package com.example.store.routes;

import com.example.store.models.Cart;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class CartRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:getCartByUser")
                .id("getCartByUser")
                .log("Vai consultar o catálogo do id-cliente ${header.idCliente}")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader("accept", constant("application/json"))
                .setHeader("Accept-Encoding", constant("gzip"))
                .log("GET >> {{fake-store-api.uri}}/carts/${header.idCliente}")
                .toD("{{fake-store-api.uri}}/carts/user/${header.idCliente}?bridgeEndpoint=true")
                .unmarshal(new ListJacksonDataFormat(Cart.class));
    }
}
