package com.twitterMetrics.nflLeague.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gameDate")
    private Date gameDate;
    @Column(name = "location")
    private String location;
    @Column(name = "week")
    private Number week;
    @Column(name = "seasonType")
    private String seasonType;
    @Column(name = "isHomeGame")
    private HomeAwayGame isHomeGame;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @OneToMany( mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> teamList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Number getWeek() {
        return week;
    }

    public void setWeek(Number week) {
        this.week = week;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public HomeAwayGame getIsHomeGame() {
        return isHomeGame;
    }

    public void setIsHomeGame(HomeAwayGame isHomeGame) {
        this.isHomeGame = isHomeGame;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Game> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Game> teamList) {
        this.teamList = teamList;
    }
}
