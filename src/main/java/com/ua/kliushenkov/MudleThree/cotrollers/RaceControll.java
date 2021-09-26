package com.ua.kliushenkov.MudleThree.cotrollers;


import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.service.RaceAction;
import com.ua.kliushenkov.MudleThree.service.RaceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController("/race")
public class RaceControll {

    private RaceService raceService;
    private RaceAction raceAction = new RaceAction();

    public RaceControll(RaceService raceService) {
        this.raceService = raceService;
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Race getRaceById(@PathVariable int id){
       return raceService.findById(id);
    }

    @PostMapping("/start/")
    public void startRace(@RequestParam int horseCount, @RequestParam int betOn){
        raceService.saveRace(raceAction.startRace(horseCount,betOn));
    }
}
