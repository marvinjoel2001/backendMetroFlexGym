package com.api.metroflex_backend.controllers;

import com.api.metroflex_backend.models.MonthlySubscriptionModel;
import com.api.metroflex_backend.services.MonthlySubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monthly-subscription")
public class MonthlySubscriptionController {

    @Autowired
    private MonthlySubscriptionService monthlySubscriptionService;

    @GetMapping
    public List<MonthlySubscriptionModel> getAllMonthlySubscriptions() {
        return monthlySubscriptionService.getAllMonthlySubscriptions();
    }

    @PostMapping
    public MonthlySubscriptionModel createMonthlySubscription(@RequestBody MonthlySubscriptionModel monthlySubscription) {
        return monthlySubscriptionService.saveMonthlySubscription(monthlySubscription);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MonthlySubscriptionModel> getMonthlySubscriptionById(@PathVariable("id") Long id) {
        Optional<MonthlySubscriptionModel> optionalSubscription = monthlySubscriptionService.getMonthlySubscriptionById(id);
        return optionalSubscription
                .map(subscription -> ResponseEntity.ok(subscription))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MonthlySubscriptionModel> updateMonthlySubscriptionById(
            @RequestBody MonthlySubscriptionModel request,
            @PathVariable("id") Long id) {
        try {
            MonthlySubscriptionModel updatedSubscription = monthlySubscriptionService.updateById(request, id);
            return ResponseEntity.ok(updatedSubscription);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteMonthlySubscription(@PathVariable Long id) {
        boolean deleted = monthlySubscriptionService.deleteMonthlySubscription(id);
        if (deleted) {
            return ResponseEntity.ok("Monthly subscription with ID " + id + " deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
