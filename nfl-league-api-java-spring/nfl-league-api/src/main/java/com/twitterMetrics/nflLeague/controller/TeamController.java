package com.twitterMetrics.nflLeague.controller;

import com.twitterMetrics.nflLeague.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;
    

}