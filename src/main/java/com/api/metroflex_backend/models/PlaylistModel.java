package com.api.metroflex_backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
public class PlaylistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserModel creator;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<SongModel> songs = new ArrayList<>();



    // Getter y setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //Getter y setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Getter y setter para creator
    public UserModel getCreator() {
        return creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }
    // Getter y setter para songs
    public List<SongModel> getSongs() {
        return songs;
    }

    public void setSongs(List<SongModel> songs) {
        this.songs = songs;
    }
}
