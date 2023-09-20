package com.api.metroflex_backend.repositories;

import com.api.metroflex_backend.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
}
