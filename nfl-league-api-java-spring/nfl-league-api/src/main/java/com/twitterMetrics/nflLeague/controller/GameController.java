package com.twitterMetrics.nflLeague.controller;

import com.twitterMetrics.nflLeague.exception.RecordNotFoundException;
import com.twitterMetrics.nflLeague.model.Game;
import com.twitterMetrics.nflLeague.repository.GameRepository;
import com.twitterMetrics.nflLeague.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private SeasonRepository seasonRepository;
    @GetMapping("/seasons/{seasonId}/games")
    public List<Game> getGames(@PathVariable(value = "seasonId") Long seasonId) {
        return gameRepository.findAll();
    }
    @GetMapping("/seasons/{seasonId}/games/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable(value = "seasonId") Long seasonId, @PathVariable(value = "gameId") Long gameId) {
        if(!seasonRepository.existsById(seasonId)) {
            throw new RecordNotFoundException("record not found by id: " + seasonId);
        }
        return  gameRepository.findByIdAndSeasonId(gameId, seasonId).
                map(game -> ResponseEntity.ok().body(game)).
                orElseThrow(() -> new RecordNotFoundException("record not found by id: " + seasonId));
    }
    @PostMapping("/seasons/{seasonId}/games")
    public Game createGame(@PathVariable(value = "seasonId") Long seasonId, @RequestBody Game game) {
        return seasonRepository.findById(seasonId).map(season -> {
            game.setSeason(season);
            return gameRepository.save(game);
        }).orElseThrow(() -> new RecordNotFoundException("record not found by id: " + seasonId));
    }
    @PutMapping("/seasons/{seasonId}/games/{gameId}")
    public Game updateGame(@PathVariable(value = "seasonId") Long seasonId, @PathVariable(value = "gameId") Long gameId, @RequestBody Game gameDetails) {
        if(!seasonRepository.existsById(seasonId)) {
            throw new RecordNotFoundException("record not found by id: " + seasonId);
        }
        return gameRepository.findById(gameId).map(game -> {
            game.setGameDate(gameDetails.getGameDate());
            game.setSeasonType(gameDetails.getSeasonType());
            game.setIsHomeGame(gameDetails.getIsHomeGame());
            game.setLocation(gameDetails.getLocation());
            game.setWeek(gameDetails.getWeek());
            return gameRepository.save(game);
        }).orElseThrow(() -> new RecordNotFoundException("record not found by id: " + seasonId));
    }
    @DeleteMapping("/seasons/{seasonId}/games/{gameId}")
    public Map<String, Boolean> deleteGame(@PathVariable(value = "seasonId") Long seasonId, @PathVariable(value = "gameId") Long gameId) {
        if(!seasonRepository.existsById(seasonId)) {
            throw new RecordNotFoundException("record not found by id: " + seasonId);
        }
        return gameRepository.findById(gameId).map(game -> {
            gameRepository.delete(game);
            Map<String, Boolean> deletedGame = new HashMap<>();
            deletedGame.put("deleted", Boolean.TRUE);
            return deletedGame;
        }).orElseThrow(() -> new RecordNotFoundException("record not found by id: " + seasonId));
    }
}
