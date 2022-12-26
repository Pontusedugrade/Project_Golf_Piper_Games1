package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List <Player> teamMembers = new ArrayList<>();


    // Constructor
    public Team() {
    }

    public Team(String teamName, Game gameId) {
        this.teamName = teamName;
        this.gameId = gameId;
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

    public List<Player> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMembers(Player player) {
        this.teamMembers.add(player);
    }
}

