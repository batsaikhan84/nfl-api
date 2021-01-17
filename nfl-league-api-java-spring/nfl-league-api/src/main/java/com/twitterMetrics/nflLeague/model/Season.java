package com.twitterMetrics.nflLeague.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year", nullable = false, unique = true)
    private String year;
    @OneToMany( mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> gameList = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public String getYear() {
        return year;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setYear(String season) {
        this.year = season;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
