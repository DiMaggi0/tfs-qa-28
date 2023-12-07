package ru.tinkoff.qa.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    int id;
    @Column(name="\"name\"")
    String name;
    @Column(name="age")
    int age;
    @Column(name="\"type\"")
    int type;
    @Column(name="sex")
    int sex;
    @Column(name="place")
    int place;

    public void setId(int id) {
        this.id = id;
    }

}
