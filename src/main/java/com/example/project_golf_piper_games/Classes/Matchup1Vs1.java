package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "matchup_1vs1")

public class Matchup1Vs1 {

    //Properties
    @Column(name = "match_date")
    private LocalDateTime datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchup_1vs1_id")
    private int matchup1vs1Id;

    //Foreign KEY:
    @Column(name = "player1_id")
    private int player1Id;

    //Foreign KEY:
    @Column(name = "player2_id")
    private int player2Id;

    @Column(name = "winner_id")
    private int winnerId;

    @Column(name = "player1_score")
    private int player1Score;

    @Column(name = "player2_score")
    private int player2Score;

    //Foreign KEY
    @Column(name = "game_id")
    private int gameId;


    //Constructor

    public Matchup1Vs1() {

    }

    public Matchup1Vs1(LocalDateTime datetime, int matchup1vs1Id, int player1Id, int player2Id, int winnerId, int player1Score, int player2Score, int gameId) {
        this.datetime = datetime;
        this.matchup1vs1Id = matchup1vs1Id;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.winnerId = winnerId;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.gameId = gameId;
    }

    //METHODS


    //GETTER AND SETTER METHODS

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public int getMatchup1vs1Id() {
        return matchup1vs1Id;
    }

    public void setMatchup1vs1Id(int matchup1vs1Id) {
        this.matchup1vs1Id = matchup1vs1Id;
    }

    public int getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(int player1Id) {
        this.player1Id = player1Id;
    }

    public int getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(int player2Id) {
        this.player2Id = player2Id;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}

