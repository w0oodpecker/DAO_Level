package com.example.dao_level.controller;

import com.example.dao_level.repository.Orders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DaoController {

    private Orders orders;

    DaoController(Orders orders) {
        this.orders = orders;
    }

    @GetMapping("/products/fetch-product")
    public List<String> fetchProduct(@RequestParam("name") String name) {
        return orders.getProductName(name);
    }
}
