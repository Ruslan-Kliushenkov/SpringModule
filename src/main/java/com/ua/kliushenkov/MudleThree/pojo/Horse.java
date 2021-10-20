package com.ua.kliushenkov.MudleThree.pojo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString(of = {"id,name,place"})
@Table(name = "hrs")

public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int place;

    @Column
    private String name;

    @Column
    private int num;


    public Horse(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Horse() {
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
