package com.api.metroflex_backend.services;

import com.api.metroflex_backend.models.SongModel;
import com.api.metroflex_backend.repositories.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private ISongRepository songRepository;

    public List<SongModel> getSongs() {
        return songRepository.findAll();
    }

    public SongModel saveSong(SongModel song) {
        return songRepository.save(song);
    }

    public Optional<SongModel> getById(Long id) {
        return songRepository.findById(id);
    }

    public SongModel updateById(SongModel request, Long id) {
        Optional<SongModel> optionalSong = songRepository.findById(id);

        if (optionalSong.isPresent()) {
            SongModel song = optionalSong.get();

            // Verificar que los campos no sean nulos antes de actualizarlos
            if (request.getTitle() != null) {
                song.setTitle(request.getTitle());
            }
            if (request.getArtist() != null) {
                song.setArtist(request.getArtist());
            }
            if (request.getUrl() != null) {
                song.setUrl(request.getUrl());
            }
            // Actualizar las listas de reproducción solo si el objeto request contiene una lista de reproducción válida
            if (request.getPlaylists() != null) {
                song.setPlaylists(request.getPlaylists());
            }

            // Agregar aquí otros campos para actualizar si es necesario

            return songRepository.save(song); // Guardar los cambios en la base de datos
        } else {
            // Manejar el caso en el que no se encuentre la canción con el ID dado
            throw new IllegalArgumentException("Canción no encontrada con el ID proporcionado: " + id);
        }
    }

    public boolean deleteSong(Long id) {
        try {
            songRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}