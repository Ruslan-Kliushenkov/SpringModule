package com.ua.kliushenkov.MudleThree.cotrollers;


import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController()
public class StatsController {

    private final RaceRepository raceRepository;

    @Autowired
    public StatsController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Race> getStatistic() {
        return (ArrayList<Race>) raceRepository.findAll();
    }
}
