package com.api.metroflex_backend.controllers;


import com.api.metroflex_backend.models.PlaylistModel;
import com.api.metroflex_backend.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<PlaylistModel> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @PostMapping
    public PlaylistModel createPlaylist(@RequestBody PlaylistModel playlist) {
        return playlistService.savePlaylist(playlist);
    }

    @GetMapping("/{id}")
    public Optional<PlaylistModel> getPlaylistById(@PathVariable("id") Long id) {
        return playlistService.getById(id);
    }

    @PutMapping("/{id}")
    public PlaylistModel updatePlaylistById(@RequestBody PlaylistModel request, @PathVariable("id") Long id) {
        return playlistService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        boolean ok = playlistService.deletePlaylist(id);
        if (ok) {
            return "Playlist with id " + id + " deleted";
        } else {
            return "Oops, we have a problem";
        }
    }
}
