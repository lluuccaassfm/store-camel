package com.example.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Cart {

    private Integer id;

    private Integer userId;

    private String date;

    private List<ProductCart> products;

    @JsonProperty("__v")
    private Integer v;

}
