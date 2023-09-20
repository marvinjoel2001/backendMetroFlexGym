package com.api.metroflex_backend.repositories;

import com.api.metroflex_backend.models.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<NotificationModel, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
}
