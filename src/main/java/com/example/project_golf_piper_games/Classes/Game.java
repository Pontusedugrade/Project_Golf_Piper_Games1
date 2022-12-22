package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "game")

public class Game {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;

    @Column(name = "name")
    private String name;

    //Constructor

    public Game() {

    }

    public Game(int gameId, String name) {
        this.gameId = gameId;
        this.name = name;
    }

    //METHODS


    //GETTER AND SETTER METHODS

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
