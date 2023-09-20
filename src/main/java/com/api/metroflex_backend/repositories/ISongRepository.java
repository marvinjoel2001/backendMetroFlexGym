package com.api.metroflex_backend.repositories;


import com.api.metroflex_backend.models.SongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<SongModel, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
}
