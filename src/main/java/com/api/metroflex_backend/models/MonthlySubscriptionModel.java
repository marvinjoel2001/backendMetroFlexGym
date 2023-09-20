package com.api.metroflex_backend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "monthly_subscription")
public class MonthlySubscriptionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    // Agregar referencia al modelo de usuario
    @ManyToOne
    private UserModel user;

    // Otras propiedades según sea necesario

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    // Otros getters y setters según sea necesario
}
