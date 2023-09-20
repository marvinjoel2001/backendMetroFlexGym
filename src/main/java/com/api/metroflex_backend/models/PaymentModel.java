package com.api.metroflex_backend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payment")
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double amount;

    @Column
    private Date date;

    @ManyToOne
    private MonthlySubscriptionModel monthlySubscription;

    // Otras propiedades según sea necesario

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MonthlySubscriptionModel getMonthlySubscription() {
        return monthlySubscription;
    }

    public void setMonthlySubscription(MonthlySubscriptionModel monthlySubscription) {
        this.monthlySubscription = monthlySubscription;
    }


}

