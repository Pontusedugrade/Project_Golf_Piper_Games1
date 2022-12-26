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

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team teamId;

    //Constructor
    public Player() {
    }

     /*We learned this concept in the first course. "this" refers to the object created by this constructor. Once a player is created, he/she is added to the list of team
     members based on the teamId*/
    public Player(Person personId, Game gameId, Team teamId) {
        this.personId = personId;
        this.gameId = gameId;
        this.teamId = teamId;
        teamId.addTeamMembers(this);
    }

    public Player(Person personId, Game gameId) {
        this.personId = personId;
        this.gameId = gameId;
    }

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

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}

