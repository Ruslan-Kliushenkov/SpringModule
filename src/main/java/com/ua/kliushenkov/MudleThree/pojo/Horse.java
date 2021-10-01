package com.ua.kliushenkov.MudleThree.pojo;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter

public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int place;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn()
    private Race race;
    @Column
    private String name;

    public Horse(int id, int place, String name) {
        this.id = id;
        this.place = place;
        this.name = name;
    }

    public Horse(String name) {
        this.name = name;
    }

    public Horse() {
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
