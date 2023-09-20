package com.api.metroflex_backend.controllers;


import com.api.metroflex_backend.models.SongModel;
import com.api.metroflex_backend.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<SongModel> getSongs() {
        return songService.getSongs();
    }

    @PostMapping
    public SongModel createSong(@RequestBody SongModel song) {
        return songService.saveSong(song);
    }

    @GetMapping("/{id}")
    public Optional<SongModel> getSongById(@PathVariable("id") Long id) {
        return songService.getById(id);
    }

    @PutMapping("/{id}")
    public SongModel updateSongById(@RequestBody SongModel request, @PathVariable("id") Long id) {
        return songService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable Long id) {
        boolean ok = songService.deleteSong(id);
        if (ok) {
            return "Song with id " + id + " deleted";
        } else {
            return "Oops, we have a problem";
        }
    }
}
