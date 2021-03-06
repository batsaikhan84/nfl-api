package com.twitterMetrics.nflLeague.model;
import javax.persistence.*;

@Entity
public class Team extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "conference", nullable = false)
    private String conference;
    @Column(name = "city", nullable = false)
    private String city;
//    @ManyToOne
//    @JoinColumn(name = "game_id")
//    private Game game;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public String getCity() {
        return city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
}