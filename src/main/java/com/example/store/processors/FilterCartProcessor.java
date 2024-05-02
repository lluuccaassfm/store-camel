package com.example.store.processors;

import com.example.store.models.Cart;
import com.example.store.models.ProductCart;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FilterCartProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<Cart> carts = exchange.getMessage().getBody(List.class);
        Integer idCart = exchange.getMessage().getHeader("idCart", Integer.class);
        Optional<Cart> cart = carts.stream().filter(v -> v.getId().equals(idCart)).findFirst();

        if (cart.isEmpty()) {
            throw new Exception("Nenhum carrinho encontrado para o cliente ${header.idCliente} carrinho ${header.idCart}");
        }

        exchange.setProperty("products", cart.get().getProducts());
        exchange.setProperty("response", new ArrayList<ProductCart>());
    }
}
