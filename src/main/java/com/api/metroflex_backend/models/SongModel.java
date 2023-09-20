package com.api.metroflex_backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "song")
public class SongModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String artist;
    @Column
    private String url;
    @ManyToMany(mappedBy = "songs")
    private List<PlaylistModel> playlists = new ArrayList<>();

    public List<PlaylistModel> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistModel> playlists) {
        this.playlists = playlists;
    }
    // Getter y Setter para 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y Setter para 'title'
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter y Setter para 'artist'
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Getter y Setter para 'url'
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
