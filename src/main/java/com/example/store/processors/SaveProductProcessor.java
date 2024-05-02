package com.example.store.processors;

import com.example.store.models.Product;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveProductProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<Product> response = exchange.getProperty("response", List.class);
        response.add(exchange.getMessage().getBody(Product.class));
        exchange.setProperty("response", response);
    }
}
