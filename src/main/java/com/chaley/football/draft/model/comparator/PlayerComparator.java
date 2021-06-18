package com.chaley.football.draft.model.comparator;

import java.util.Comparator;

import com.chaley.football.draft.model.Player;

public class PlayerComparator implements Comparator<Player> {

	public int compare(Player player1, Player player2) {
		return player1.getLastName().compareTo(player2.getLastName());
	}

}