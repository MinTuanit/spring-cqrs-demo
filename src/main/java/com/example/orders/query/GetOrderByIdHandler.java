package com.example.orders.query;

import com.example.orders.domain.Order;
import com.example.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetOrderByIdHandler {

    private final OrderRepository orderRepository;

    public Optional<Order> handle(GetOrderByIdQuery query) {
        return orderRepository.findById(query.getOrderId());
    }
}