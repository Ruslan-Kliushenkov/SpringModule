package com.ua.kliushenkov.MudleThree.cotrollers;


import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

@Controller
public class StatsController {

    private final RaceRepository raceRepository;

    @Autowired
    public StatsController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping("/stats")
    public String getStatistic(Map<String, Object> model) {
        Iterable<Race> races = raceRepository.findAll();
        model.put("raceList", races);
        return "statistic";
    }

    @GetMapping("/race")
    public String getRace(
            @RequestParam Long id,
            Model model
    ){
      Race race = raceRepository.getById(id);
      model.addAttribute("race", race);
      return "race";
    }

    @GetMapping("/result")
    public String result(
            Model model
    ){
        Race race = raceRepository.findAll().stream()
                .max(Comparator.comparingLong(Race::getId))
                .orElse(null);
        model.addAttribute("race", race);
        return "result";
    }
}
