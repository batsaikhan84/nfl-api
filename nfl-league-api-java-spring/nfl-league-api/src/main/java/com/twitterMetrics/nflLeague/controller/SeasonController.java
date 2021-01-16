package com.twitterMetrics.nflLeague.controller;

import com.twitterMetrics.nflLeague.model.Season;
import com.twitterMetrics.nflLeague.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeasonController {
    @Autowired
    private SeasonRepository seasonRepository;
    @GetMapping("/seasons")
    public List<Season> getSeasons() { return seasonRepository.findAll(); }
}
