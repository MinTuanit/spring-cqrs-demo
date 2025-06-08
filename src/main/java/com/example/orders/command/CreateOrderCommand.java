package com.example.orders.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderCommand {
    private String userId;
    private String items;
}