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
    private String gameName;

    //Constructor

    public Game() {

    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    //METHODS


    //GETTER AND SETTER METHODS


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
