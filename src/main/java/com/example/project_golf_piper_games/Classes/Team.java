package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "team")

public class Team {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name")
    private String teamName;

    //Foreign KEY
    @Column(name = "game_id")
    private int gameId;

    //Foreign KEY
    @Column(name = "playerId")
    private int playerId;


    //Constructor
    public Team() {

    }

    public Team(int teamId, String teamName, int gameId, int playerId) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.gameId = gameId;
        this.playerId = playerId;
    }

    //METHODS


    //GETTER AND SETTER METHODS


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}

