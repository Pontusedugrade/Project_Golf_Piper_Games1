package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matchup_teamvsteam")

public class MatchupTeamVsTeam {

    //Properties
    @Column(name = "match_date")
    private LocalDateTime datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchup_teamvsteam_id")
    private int matchupTeamVsTeamId;

    //Foreign KEY:
    @Column(name = "team1_id")
    private int player1Id;

    //Foreign KEY:
    @Column(name = "team2_id")
    private int player2Id;

    @Column(name = "winner_id")
    private int winnerId;

    @Column(name = "team1_score")
    private int player1Score;

    @Column(name = "team2_score")
    private int player2Score;

    //Foreign KEY
    @Column(name = "game_id")
    private int gameId;


    //Constructor

    public MatchupTeamVsTeam() {

    }

    public MatchupTeamVsTeam(LocalDateTime datetime, int matchupTeamVsTeamId, int player1Id, int player2Id, int winnerId, int player1Score, int player2Score, int gameId) {
        this.datetime = datetime;
        this.matchupTeamVsTeamId = matchupTeamVsTeamId;
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

    public int getMatchupTeamVsTeamId() {
        return matchupTeamVsTeamId;
    }

    public void setMatchupTeamVsTeamId(int matchupTeamVsTeamId) {
        this.matchupTeamVsTeamId = matchupTeamVsTeamId;
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

