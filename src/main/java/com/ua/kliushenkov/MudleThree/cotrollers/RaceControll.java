package com.ua.kliushenkov.MudleThree.cotrollers;


import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.repository.RaceRepository;
import com.ua.kliushenkov.MudleThree.service.RaceAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController("/race")
public class RaceControll {

    private RaceAction raceAction = new RaceAction();

    private final RaceRepository raceRepository;

    @Autowired
    public RaceControll(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping(value = "/race/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Race getRaceById(@PathVariable Long id) {
        return raceRepository.findById(id).orElseThrow();
    }

    @PostMapping("/race/start/")
    public void startRace(@RequestParam int horseCount, @RequestParam int betOn) {
        raceRepository.save(raceAction.startRace(horseCount, betOn));
    }
}
