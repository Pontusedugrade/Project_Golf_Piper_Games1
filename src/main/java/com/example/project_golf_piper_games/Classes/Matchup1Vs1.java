package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "matchup_1vs1")

public class Matchup1Vs1 {

    //Properties
    @Column(name = "match_date")
    private LocalDate localDate;
    // Check the comments at the end of this class for a summary about inputting and printing LocalDateTime values.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchup_1vs1_id")
    private int matchup1vs1Id;

    @Column(name = "player1_score")
    private int player1Score;

    @Column(name = "player2_score")
    private int player2Score;

    // FKs:
    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1Id;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private Player player2Id;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winnerId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    //Constructor
    public Matchup1Vs1() {
    }

    public Matchup1Vs1(LocalDate localDate, int player1Score, int player2Score, Player player1Id, Player player2Id, Player winnerId, Game gameId) {
        this.localDate = localDate;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.winnerId = winnerId;
        this.gameId = gameId;
    }

    // Getters & Setters
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getMatchup1vs1Id() {
        return matchup1vs1Id;
    }

    public String getPlayer1Nick(){
        return this.player1Id.getPlayerNickName();
    }
    public String getPlayer2Nick(){
        return this.player2Id.getPlayerNickName();
    }

    public void setMatchup1vs1Id(int matchup1vs1Id) {
        this.matchup1vs1Id = matchup1vs1Id;
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

    public Player getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Player player1Id) {
        this.player1Id = player1Id;
    }

    public Player getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Player player2Id) {
        this.player2Id = player2Id;
    }

    public Player getWinnerId() {
        return winnerId;
    }

    public String getWinnerNick(){
        return this.winnerId.getPlayerNickName();
    }

    public void setWinnerId(Player winnerId) {
        this.winnerId = winnerId;
    }

    public String getGameName(){
        return this.gameId.getGameName();
    }
    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }
    /*
    Code:
      LocalDateTime dateTimeInput = LocalDateTime.of(1987, 11, 20, 12, 50);
      System.out.println(dateTimeInput);
    Output:
      1987-11-20T12:50
    Code:
      DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm");
      String formattedDate = customFormat.format(dateTimeInput);
      System.out.println(formattedDate);
    Output:
      1987-11-20  12:50
    Note:
      In the first code, adding another number will be the seconds.
      You can customize the format of DateTime in any way you like.
    */
}

