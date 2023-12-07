package ru.tinkoff.qa.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="places")
public class Places {
    @Id
    int id;
    @Column(name="\"row\"")
    int row;
    @Column(name="place_num")
    int place_num;
    @Column(name="\"name\"")
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setPlace_num(int place_num) {
        this.place_num = place_num;
    }

    public void setName(String name) {
        this.name = name;
    }
}
