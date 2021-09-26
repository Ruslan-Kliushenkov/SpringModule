package com.ua.kliushenkov.MudleThree.service;

import com.ua.kliushenkov.MudleThree.pojo.Race;
import com.ua.kliushenkov.MudleThree.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Race findById(int id) {
        return raceRepository.findById(id).orElseThrow();
    }

    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    public Race saveRace(Race race) {
        return raceRepository.save(race);
    }

    public void deleteById(int id) {
        raceRepository.deleteById(id);
    }
}
