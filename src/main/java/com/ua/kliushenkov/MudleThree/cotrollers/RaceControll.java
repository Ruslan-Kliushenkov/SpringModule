package com.ua.kliushenkov.MudleThree.cotrollers;


import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.repository.RaceRepository;
import com.ua.kliushenkov.MudleThree.service.RaceAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RaceControll {

    private RaceAction raceAction = new RaceAction();

    private final RaceRepository raceRepository;

    @Autowired
    public RaceControll(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping(value = "/")
    public String home(Map<String, Object> model){
        return "action";
    }

    @GetMapping(value = "/race/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Race getRaceById(@PathVariable Long id) {
        return raceRepository.findById(id).orElseThrow();
    }

    @PostMapping("/start")
    public String startRace(
            @RequestParam int horseCount,
            @RequestParam int betOn,
            Model model
    ) {
        if (horseCount<3) {
            model.addAttribute("message", "Horses should be more than 2");
            return "action";
        }

        if (betOn>horseCount) {
            model.addAttribute("message", "Count of horses > Bet on");
            return "action";
        }

        raceRepository.save(raceAction.startRace(horseCount, betOn));
        return "redirect:/result";
    }
}
