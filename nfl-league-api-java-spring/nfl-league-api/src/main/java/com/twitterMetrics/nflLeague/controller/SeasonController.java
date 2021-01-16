package com.twitterMetrics.nflLeague.controller;

import com.twitterMetrics.nflLeague.exception.RecordNotFoundException;
import com.twitterMetrics.nflLeague.model.Season;
import com.twitterMetrics.nflLeague.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SeasonController {
    @Autowired
    private SeasonRepository seasonRepository;
    @GetMapping("/seasons")
    public List<Season> getSeasons() { return seasonRepository.findAll(); }
    @GetMapping("/seasons/{id}")
    public ResponseEntity<Season> getSeason(@PathVariable(value = "id") Long id) throws RecordNotFoundException {
        Season season = seasonRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("record is not found by id:" + id));
        return ResponseEntity.ok().body(season);
    }
    @PostMapping("/seasons")
    public Season createSeason(@RequestBody Season season) { return seasonRepository.save(season); }

}
