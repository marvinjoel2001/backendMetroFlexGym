package com.api.metroflex_backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;
    @Column
    private String qrCode;
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<PlaylistModel> playlists = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotificationModel> notifications = new ArrayList<>();
    // Getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter para 'qrCode'
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    // Getter y setter para playlists
    public List<PlaylistModel> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistModel> playlists) {
        this.playlists = playlists;
    }
}


