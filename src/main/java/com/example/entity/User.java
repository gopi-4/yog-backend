package com.example.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    @Column(nullable = false)
    private Date dob;
    @Column(nullable = false)
    private String slot;
    @Column(nullable = false)
    private Date registration_date;
    @Column(nullable = false)
    private boolean payment_status;

    public User(String name, String email, String phone, Date dob, String slot) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.slot = slot;
        this.registration_date = new java.sql.Date(System.currentTimeMillis());
    }

    public User() {
        super();
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDob() {
        return dob;
    }

    public String getSlot() {
        return slot;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public boolean getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
