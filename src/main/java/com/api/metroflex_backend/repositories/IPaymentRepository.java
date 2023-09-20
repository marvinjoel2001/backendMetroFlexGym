package com.api.metroflex_backend.repositories;

import com.api.metroflex_backend.models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentModel, Long> {
}
