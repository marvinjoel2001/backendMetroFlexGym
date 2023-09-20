package com.api.metroflex_backend.controllers;

import com.api.metroflex_backend.models.PaymentModel;
import com.api.metroflex_backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentModel> getPayments() {
        return paymentService.getPayments();
    }

    @PostMapping
    public PaymentModel createPayment(@RequestBody PaymentModel payment) {
        return paymentService.savepayment(payment);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable("id") Long id) {
        Optional<PaymentModel> optionalPayment = paymentService.getById(id);
        return optionalPayment
                .map(payment -> ResponseEntity.ok(payment))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PaymentModel> updatePaymentById(@RequestBody PaymentModel request, @PathVariable("id") Long id) {
        try {
            PaymentModel updatedPayment = paymentService.updateById(request, id);
            return ResponseEntity.ok(updatedPayment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        boolean deleted = paymentService.deletePayment(id);
        if (deleted) {
            return ResponseEntity.ok("Payment with ID " + id + " deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

