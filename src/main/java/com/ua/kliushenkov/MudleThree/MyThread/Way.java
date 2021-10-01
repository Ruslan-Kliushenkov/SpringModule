package com.ua.kliushenkov.MudleThree.MyThread;

import com.ua.kliushenkov.MudleThree.service.RaceAction;

import java.util.Random;

public class Way extends Thread {
    Random random = new Random();

    RaceAction race = new RaceAction();
    private final int START_POINT = 0;
    private final int ALL_DISTANCE = 1000;
    private int currentPosition;
    private String name;

    public Way(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (this.currentPosition < ALL_DISTANCE) {
            this.currentPosition += getRandomStep();
            try {
                Thread.sleep(getRandomSleepTime());
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
        RaceAction.addToList(Thread.currentThread().getName());

    }



    private int getRandomStep() {
        return 100 + random.nextInt(100);
    }

    private int getRandomSleepTime() {
        return 400 + random.nextInt(100);
    }

}
