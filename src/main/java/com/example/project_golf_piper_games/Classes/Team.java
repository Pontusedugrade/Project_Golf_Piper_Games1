package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

  /*@OneToMany
  @Column(name = "playerId")
  private List<Player> teammates = new ArrayList<>();*/

  @OneToMany
  @JoinTable(name = "team_player",
          joinColumns = {@JoinColumn(name = "team__id", referencedColumnName = "team_id")},
          inverseJoinColumns = {@JoinColumn(name = "player__id", referencedColumnName = "player_id")}
  )
  private List <Player> teammates = new ArrayList<>();



  // Constructor
  public Team() {
  }

  public Team(String teamName, Game gameId) {
    this.teamName = teamName;
    this.gameId = gameId;
  }

  public Team(String teamName, Game gameId, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6, Player player7, Player player8) {
    this.teamName = teamName;
    this.gameId = gameId;
    teammates.add(player1);
    teammates.add(player2);
    teammates.add(player3);
    teammates.add(player4);
    teammates.add(player5);
    teammates.add(player6);
    teammates.add(player7);
    teammates.add(player8);
    teammates.removeIf(Objects::isNull);
    /*for (Player teammate : teammates)
      if (teammate == null)
        teammates.remove(teammate);*/
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

  public List<Player> originalTeammatesGetter() {
    return teammates;
  }

  public List <String> getTeammates() {
    List <String> teammates_nickNames = new ArrayList<>();
    for (Player player :  teammates) {
      if (player.getPlayerNickName() != null) {
        teammates_nickNames.add(player.getPlayerNickName());
      }
    }
    return teammates_nickNames;
  }

  public void addTeammates(Player player) {
    this.teammates.add(player);
  }
}

