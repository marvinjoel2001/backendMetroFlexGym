package com.api.metroflex_backend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notification")
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;

    @Column
    private Date sentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    // Getter para 'id'
    public Long getId() {
        return id;
    }

    // Setter para 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para 'message'
    public String getMessage() {
        return message;
    }

    // Setter para 'message'
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter para 'sentDate'
    public Date getSentDate() {
        return sentDate;
    }

    // Setter para 'sentDate'
    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    // Getter para 'user'
    public UserModel getUser() {
        return user;
    }

    // Setter para 'user'
    public void setUser(UserModel user) {
        this.user = user;
    }
}
