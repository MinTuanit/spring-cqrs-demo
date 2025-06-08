package com.example.orders.controller;

import com.example.orders.command.CreateOrderCommand;
import com.example.orders.command.CreateOrderHandler;
import com.example.orders.domain.Order;
import com.example.orders.query.GetOrderByIdHandler;
import com.example.orders.query.GetOrderByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderHandler createHandler;
    private final GetOrderByIdHandler queryHandler;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateOrderCommand command) {
        String id = createHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        Optional<Order> result = queryHandler.handle(new GetOrderByIdQuery(id));
        return result.map(order -> ResponseEntity.ok((Object) order))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found"));
    }
}