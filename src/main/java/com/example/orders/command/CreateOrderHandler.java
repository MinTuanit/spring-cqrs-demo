package com.example.orders.command;

import com.example.orders.domain.Order;
import com.example.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateOrderHandler {

    private final OrderRepository orderRepository;

    public String handle(CreateOrderCommand command) {
        Order order = new Order(
                UUID.randomUUID().toString(),
                command.getUserId(),
                command.getItems(),
                "pending",
                LocalDateTime.now()
        );
        orderRepository.save(order);
        return order.getId();
    }
}