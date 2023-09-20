package com.api.metroflex_backend.services;

import com.api.metroflex_backend.models.PlaylistModel;
import com.api.metroflex_backend.repositories.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private IPlaylistRepository playlistRepository;

    public List<PlaylistModel> getPlaylists() {
        return playlistRepository.findAll();
    }

    public PlaylistModel savePlaylist(PlaylistModel playlist) {
        return playlistRepository.save(playlist);
    }

    public Optional<PlaylistModel> getById(Long id) {
        return playlistRepository.findById(id);
    }

    public PlaylistModel updateById(PlaylistModel request, Long id) {
        Optional<PlaylistModel> optionalPlaylist = playlistRepository.findById(id);

        if (optionalPlaylist.isPresent()) {
            PlaylistModel playlist = optionalPlaylist.get();

            // Verificar que los campos no sean nulos antes de actualizarlos
            if (request.getName() != null) {
                playlist.setName(request.getName());
            }
            // Actualizar el creador solo si el objeto request contiene un creador válido
            if (request.getCreator() != null) {
                playlist.setCreator(request.getCreator());
            }
            // Actualizar las canciones solo si el objeto request contiene una lista de canciones válida
            if (request.getSongs() != null) {
                playlist.setSongs(request.getSongs());
            }

            // Agregar aquí otros campos para actualizar si es necesario

            return playlistRepository.save(playlist); // Guardar los cambios en la base de datos
        } else {
            // Manejar el caso en el que no se encuentre la lista de reproducción con el ID dado
            throw new IllegalArgumentException("Lista de reproducción no encontrada con el ID proporcionado: " + id);
        }
    }

    public boolean deletePlaylist(Long id) {
        try {
            playlistRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
