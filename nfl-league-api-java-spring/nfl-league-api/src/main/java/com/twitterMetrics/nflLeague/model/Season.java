package com.twitterMetrics.nflLeague.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Season extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year", nullable = false, unique = true)
    private String year;
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games = new ArrayList<>();

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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
