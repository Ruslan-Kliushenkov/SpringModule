package com.ua.kliushenkov.MudleThree.cotrollers;


import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/stats")
public class StatsController {

    private final RaceService raceService;

    public StatsController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Race> getStatistic(){
    return raceService.findAll();
    }
}
