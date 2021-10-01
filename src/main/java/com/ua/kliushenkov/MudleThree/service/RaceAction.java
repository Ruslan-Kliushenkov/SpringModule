package com.ua.kliushenkov.MudleThree.service;

import com.ua.kliushenkov.MudleThree.MyThread.Way;
import com.ua.kliushenkov.MudleThree.pojo.Horse;
import com.ua.kliushenkov.MudleThree.pojo.Race;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RaceAction {
    private static ArrayList<Horse> horses = new ArrayList<>();
    private int bet;


    public Race startRace(int countOfHorses, int bet) {

        this.bet = bet;

        for (int i = 1; i <= countOfHorses; i++) {
            new Way("Horse#" + i).start();
        }

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return showResult();
    }

    private Race showResult() {
        Race race = new Race();
        for (int i = 0; i < this.horses.size(); i++) {
            this.horses.get(i).setPlace(i + 1);
            race.addToList(this.horses.get(i));
        }
        race.setBetOn(bet);
        race.setDate(String.valueOf(LocalDateTime.now()));
        clearTheList();
        return race;
    }

    public static void addToList(String name){
        Horse horse = new Horse(name);
        horses.add(horse);
    }

    public static void clearTheList(){
        horses.clear();
    }

}
