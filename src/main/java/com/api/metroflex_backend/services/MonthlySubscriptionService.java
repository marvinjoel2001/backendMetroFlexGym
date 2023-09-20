package com.api.metroflex_backend.services;

import com.api.metroflex_backend.models.MonthlySubscriptionModel;
import com.api.metroflex_backend.repositories.IMonthlySubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlySubscriptionService {

    @Autowired
    private IMonthlySubscriptionRepository monthlySubscriptionRepository;

    public List<MonthlySubscriptionModel> getAllMonthlySubscriptions() {
        return monthlySubscriptionRepository.findAll();
    }

    public MonthlySubscriptionModel saveMonthlySubscription(MonthlySubscriptionModel monthlySubscription) {
        return monthlySubscriptionRepository.save(monthlySubscription);
    }

    public Optional<MonthlySubscriptionModel> getMonthlySubscriptionById(Long id) {
        return monthlySubscriptionRepository.findById(id);
    }

    public MonthlySubscriptionModel updateById(MonthlySubscriptionModel request, Long id) {
        Optional<MonthlySubscriptionModel> optionalSubscription = monthlySubscriptionRepository.findById(id);

        if (optionalSubscription.isPresent()) {
            MonthlySubscriptionModel subscription = optionalSubscription.get();

            // Verificar que los campos no sean nulos antes de actualizarlos
            if (request.getStartDate() != null) {
                subscription.setStartDate(request.getStartDate());
            }
            if (request.getEndDate() != null) {
                subscription.setEndDate(request.getEndDate());
            }
            if (request.getUser() != null) {
                subscription.setUser(request.getUser());
            }

            return monthlySubscriptionRepository.save(subscription);
        } else {
            throw new IllegalArgumentException("Monthly subscription not found with the ID provided: " + id);
        }
    }

    public boolean deleteMonthlySubscription(Long id) {
        if (monthlySubscriptionRepository.existsById(id)) {
            monthlySubscriptionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
