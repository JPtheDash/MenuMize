package com.menuqr.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    // Simulated Online Payment Processing (Replace with Razorpay/Stripe)
    @PostMapping("/pay")
    public Map<String, String> processPayment(@RequestBody Map<String, String> paymentRequest) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("transactionId", "TXN" + System.currentTimeMillis());
        return response;
    }
}
