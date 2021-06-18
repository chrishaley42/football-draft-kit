package com.chaley.football.draft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TEAM")
public class Team {
 
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String teamId;
  @Column
  private String QB1;
  @Column
  private String QB2;
  @Column
  private String QB3;
  @Column
  private String RB1;
  @Column
  private String RB2;
  @Column
  private String RB3;
  @Column
  private String WR1;
  @Column
  private String WR2;
  @Column
  private String WR3;
  @Column
  private String WR4;
  @Column
  private String WR5;
  @Column
  private String TE1;
  @Column
  private String TE2;
  @Column
  private String K1;
  @Column
  private String D;
  
  public Team() {
    
  }
    
  public Team(String teamId, String qB1, String qB2, String qB3, String rB1,
      String rB2, String rB3, String wR1, String wR2, String wR3, String wR4,
      String wR5, String tE1, String tE2, String k, String d) {
    this.teamId = teamId;
    QB1 = qB1;
    QB2 = qB2;
    QB3 = qB3;
    RB1 = rB1;
    RB2 = rB2;
    RB3 = rB3;
    WR1 = wR1;
    WR2 = wR2;
    WR3 = wR3;
    WR4 = wR4;
    WR5 = wR5;
    TE1 = tE1;
    TE2 = tE2;
    K1 = k;
    D = d;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTeamId() {
	return teamId;
  }
  public void setTeamId(String teamId) {
	this.teamId = teamId;
  }
  public String getQB1() {
    return QB1;
  }
  public void setQB1(String qB1) {
    QB1 = qB1;
  }
  public String getQB2() {
    return QB2;
  }
  public void setQB2(String qB2) {
    QB2 = qB2;
  }
  public String getQB3() {
    return QB3;
  }
  public void setQB3(String qB3) {
    QB3 = qB3;
  }
  public String getRB1() {
    return RB1;
  }
  public void setRB1(String rB1) {
    RB1 = rB1;
  }
  public String getRB2() {
    return RB2;
  }
  public void setRB2(String rB2) {
    RB2 = rB2;
  }
  public String getRB3() {
    return RB3;
  }
  public void setRB3(String rB3) {
    RB3 = rB3;
  }
  public String getWR1() {
    return WR1;
  }
  public void setWR1(String wR1) {
    WR1 = wR1;
  }
  public String getWR2() {
    return WR2;
  }
  public void setWR2(String wR2) {
    WR2 = wR2;
  }
  public String getWR3() {
    return WR3;
  }
  public void setWR3(String wR3) {
    WR3 = wR3;
  }
  public String getWR4() {
    return WR4;
  }
  public void setWR4(String wR4) {
    WR4 = wR4;
  }
  public String getWR5() {
    return WR5;
  }
  public void setWR5(String wR5) {
    WR5 = wR5;
  }
  public String getTE1() {
    return TE1;
  }
  public void setTE1(String tE1) {
    TE1 = tE1;
  }
  public String getTE2() {
    return TE2;
  }
  public void setTE2(String tE2) {
    TE2 = tE2;
  }
  public String getK1() {
    return K1;
  }
  public void setK1(String k) {
    K1 = k;
  }
  public String getD() {
    return D;
  }
  public void setD(String d) {
    D = d;
  }
  
  @Override
  public String toString() {
    return this.teamId;
  }
  
}