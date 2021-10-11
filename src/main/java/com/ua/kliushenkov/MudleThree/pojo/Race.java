package com.ua.kliushenkov.MudleThree.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rc")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id")
    private List<Horse> horseList = new ArrayList<>();

    @Column
    private String date;
    @Column
    private int betOn;

    public Race(List<Horse> horseList, String date, int betOn) {
        this.horseList = horseList;
        this.date = date;
        this.betOn = betOn;
    }

    public Race() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addToList(Horse horse) {
        this.horseList.add(horse);
    }

    public void setBetOn(int betOn) {
        this.betOn = betOn;
    }

    public List<Horse> getHorseList() {
        return horseList;
    }

    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }
}
