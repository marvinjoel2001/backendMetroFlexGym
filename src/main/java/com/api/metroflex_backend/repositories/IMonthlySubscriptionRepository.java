package com.api.metroflex_backend.repositories;

import com.api.metroflex_backend.models.MonthlySubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonthlySubscriptionRepository extends JpaRepository<MonthlySubscriptionModel,Long> {
}
