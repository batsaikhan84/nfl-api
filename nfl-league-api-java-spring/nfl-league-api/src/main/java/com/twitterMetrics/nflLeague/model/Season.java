package com.twitterMetrics.nflLeague.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year", nullable = false, unique = true)
    private String season;
    @Column(name = "seasonType", nullable = false)
    private String seasonType;
    @OneToMany( mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teamList = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public String getSeason() {
        return season;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public String getSeasonType() {
        return seasonType;
    }
    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
