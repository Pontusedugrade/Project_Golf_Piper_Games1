package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player")

public class Player {

    //Properties

    //Primary KEY:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    // FKs:
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    @ManyToMany
    @JoinColumn(name = "game_id")
    private List <Game> gameIds;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team teamId;

    //Constructor
    public Player() {
    }

    // The purpose of this constructor is when we need to register a player who isn't part of a team.
    public Player(int playerId, Person personId, List<Game> gameIds) {
        this.playerId = playerId;
        this.personId = personId;
        this.gameIds = gameIds;
    }

    public Player(int playerId, Person personId, List<Game> gameIds, Team teamId) {
        this.playerId = playerId;
        this.personId = personId;
        this.gameIds = gameIds;
        this.teamId = teamId;
    }

    // Getters & Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public List<Game> getGameIds() {
        return gameIds;
    }

    public void setGameIds(List<Game> gameId) {
        this.gameIds = gameId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}

