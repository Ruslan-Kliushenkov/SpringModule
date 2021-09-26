package com.ua.kliushenkov.MudleThree.service;

import com.ua.kliushenkov.MudleThree.MyThread.Way;
import com.ua.kliushenkov.MudleThree.pojo.Horse;
import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.pojo.tiny.ListOfHorse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RaceAction {

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
        List<Horse> horses = new ArrayList<>(ListOfHorse.getListOfHorse());

        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).setPlace(i + 1);
            race.addToList(horses.get(i));
        }
        race.setBetOn(bet);
        race.setDate(String.valueOf(LocalDateTime.now()));
        return race;

    }

}
