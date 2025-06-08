package com.example.orders.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetOrderByIdQuery {
    private String orderId;
}