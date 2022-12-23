package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matchup_teamvsteam")

public class MatchupTeamVsTeam {

    //Properties
    @Column(name = "match_date")
    private LocalDateTime datetime;
    // Comments about working with this datatype are in the above table.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchup_teamvsteam_id")
    private int matchupTeamVsTeamId;

    @Column(name = "team1_score")
    private int player1Score;

    @Column(name = "team2_score")
    private int player2Score;

    // FKs
    @ManyToOne
    @JoinColumn(name = "team1_id")
    private Team Team_1_ID;

    //Foreign KEY:
    @ManyToOne
    @JoinColumn(name = "team2_id")
    private Team Team_2_ID;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Team winnerId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;


    // Constructor
    public MatchupTeamVsTeam() {
    }

    public MatchupTeamVsTeam(LocalDateTime datetime, int matchupTeamVsTeamId, int player1Score, int player2Score, Team team_1_ID, Team team_2_ID, Team winnerId, Game gameId) {
        this.datetime = datetime;
        this.matchupTeamVsTeamId = matchupTeamVsTeamId;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        Team_1_ID = team_1_ID;
        Team_2_ID = team_2_ID;
        this.winnerId = winnerId;
        this.gameId = gameId;
    }

    // Getters & Setters
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

    public Team getTeam_1_ID() {
        return Team_1_ID;
    }

    public void setTeam_1_ID(Team team_1_ID) {
        Team_1_ID = team_1_ID;
    }

    public Team getTeam_2_ID() {
        return Team_2_ID;
    }

    public void setTeam_2_ID(Team team_2_ID) {
        Team_2_ID = team_2_ID;
    }

    public Team getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Team winnerId) {
        this.winnerId = winnerId;
    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }
}

