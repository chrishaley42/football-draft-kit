package com.chaley.football.draft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String playerId;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private String position;
  @Column
  private String team;
  @Column
  private int depthChartPosition;
  

  public Player(String playerId, String firstName, String lastName, String position,
      String team) {
    this.playerId = playerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.team = team;
  }

  public Player() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlayerId() {
	return playerId;
  }

  public void setPlayerId(String playerId) {
	this.playerId = playerId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public int getDepthChartPosition() {
    return depthChartPosition;
  }

  public void setDepthChartPosition(int depthChartPosition) {
    this.depthChartPosition = depthChartPosition;
  }
  
  @Override
  public String toString() {
    return this.playerId + " " + this.firstName + " " + this.lastName + " - " + this.position + " - " + this.team + " - " + this.depthChartPosition;
  }
  
}