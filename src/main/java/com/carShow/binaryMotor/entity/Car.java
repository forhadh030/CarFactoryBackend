package com.carShow.binaryMotor.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String make, model, color, registrationNumber;
    private int year;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Owner")
    private Owner owner;

    public Car() {
    }

    public Car(String make, String model, String color, String registrationNumber, int year, double price, Owner owner) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}


/*
    SELECT *

 */