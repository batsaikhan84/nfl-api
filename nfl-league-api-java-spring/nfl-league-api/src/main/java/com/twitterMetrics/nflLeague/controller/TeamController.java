package com.twitterMetrics.nflLeague.controller;

import com.twitterMetrics.nflLeague.exception.RecordNotFoundException;
import com.twitterMetrics.nflLeague.model.Team;
import com.twitterMetrics.nflLeague.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/teams")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
//    public Page<Team> getTeams(Pageable pageable) {
//        return teamRepository.findAll(pageable);
//    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable(value = "id") long id) throws RecordNotFoundException {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Team not found by ID: " + id));
        return ResponseEntity.ok().body(team);
    }
//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") long id, @RequestBody Team teamDetails) throws RecordNotFoundException {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Team not found by ID: " + id));
        team.setName(teamDetails.getName());
        team.setCity(teamDetails.getCity());
        team.setConference((teamDetails.getConference()));
        final Team updateTeam = teamRepository.save(team);
        return ResponseEntity.ok(updateTeam);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/teams/{id}")
    public Map<String, Boolean> deleteTeam(@PathVariable(value = "id") long id) throws RecordNotFoundException {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Team not found by ID: " + id));
        teamRepository.delete(team);
        Map<String, Boolean> deleteTeam = new HashMap<>();
        deleteTeam.put("deleted", Boolean.TRUE);
        return deleteTeam;
    }
}