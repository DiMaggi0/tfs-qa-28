package ru.tinkoff.qa.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="workman")
public class Workman {
    @Id
    int id;

    @Column(name="\"name\"", nullable = false)
    String name;
    @Column(name="age")
    int age;
    @Column(name="\"position\"")
    int position;

    public void setName(String name) {
        this.name = name;
    }
}
