package com.menuqr.controller;

import com.menuqr.model.Order;
import com.menuqr.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Place an order
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Get all pending orders (For hotel side)
    @GetMapping("/pending")
    public List<Order> getPendingOrders() {
        return orderRepository.findByStatus("Pending");
    }

    // Mark order as served
    @PutMapping("/{id}/serve")
    public String serveOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus("Served");
            orderRepository.save(order);
            return "Order served!";
        }
        return "Order not found!";
    }
}
