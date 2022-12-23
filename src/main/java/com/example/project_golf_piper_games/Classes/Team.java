package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")

public class Team {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name")
    private String teamName;

    // FKs
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @OneToMany
    @Column(name = "playerId")
    private List <Player> playerIds;


    // Constructor
    public Team() {
    }

    public Team(int teamId, String teamName, Game gameId, List<Player> playerIds) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.gameId = gameId;
        this.playerIds = playerIds;
    }

    // Getters & Setters
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

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public List<Player> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Player> playerId) {
        this.playerIds = playerId;
    }
}

