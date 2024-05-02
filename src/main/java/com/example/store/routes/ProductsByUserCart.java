package com.example.store.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductsByUserCart extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:getProductsByUserCart")
                .id("getProductsByUserCart")
                .log("Início - consulta de produtos do cliente ${header.idCliente} carrinho ${header.idCart}")
                .to("direct:getCartByUser")
                .process("filterCartProcessor")
                .log("${exchangeProperty.products.size} produtos encontrados para o cliente ${header.idCliente} carrinho ${header.idCart}")
                .split(exchangeProperty("products"))
                    .setHeader("productId", simple("${body.productId}"))
                    .to("direct:getProductFromId")
                    .process("saveProductProcessor")
                .end()
                .setBody(exchangeProperty("response"))
                .log("Fim - consulta de produtos do cliente ${header.idCliente} carrinho ${header.idCart}")
                .end();
    }
}
