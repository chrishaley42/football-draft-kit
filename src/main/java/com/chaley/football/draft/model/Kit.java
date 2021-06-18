package com.chaley.football.draft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Kit")
public class Kit {
	
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private long playerId;
	@Column
	private long userKitId;
	@Column
	private int overallRank;
	@Column
	private int posRank;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	public long getUserKitId() {
		return userKitId;
	}
	public void setUserKitId(long userKitId) {
		this.userKitId = userKitId;
	}
	public int getOverallRank() {
		return overallRank;
	}
	public void setOverallRank(int overallRank) {
		this.overallRank = overallRank;
	}
	public int getPosRank() {
		return posRank;
	}
	public void setPosRank(int posRank) {
		this.posRank = posRank;
	}
}
