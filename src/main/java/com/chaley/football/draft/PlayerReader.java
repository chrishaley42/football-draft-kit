package com.chaley.football.draft;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.chaley.football.draft.model.Player;
import com.chaley.football.draft.model.Team;
import com.chaley.football.draft.model.comparator.PlayerComparator;
import com.chaley.football.draft.model.comparator.TeamComparator;

public class PlayerReader {

	List<Player> playerList;
	List<Team> teamList;
	List<Player> qbs;
	List<Player> rbs;
	List<Player> wrs;
	List<Player> tes;
	List<Player> def;
	List<Player> ks;

	public PlayerReader() {
		playerList = new ArrayList<Player>();
		teamList = new ArrayList<Team>();
		qbs = new ArrayList<Player>();
		rbs = new ArrayList<Player>();
		wrs = new ArrayList<Player>();
		tes = new ArrayList<Player>();
		def = new ArrayList<Player>();
		ks = new ArrayList<Player>();
	}

	public void loadPlayers() {

	  getPlayers();
	  //printData();

	  getDepthCharts();
     // printTeamData();
    
    setDepthChart();
	printData();
    // TODO us lists to get players depth chart.
	}

	private void setDepthChart() {
		// loop through Team list
		// grab each position and assign to a player
		Iterator<Team> teams = teamList.iterator();
		Team team = null;
		while(teams.hasNext()) {
			team = teams.next();
			setPlayerDepthChartPos(team.getQB1(), 1);
			setPlayerDepthChartPos(team.getQB2(), 2);
			setPlayerDepthChartPos(team.getQB3(), 3);
			setPlayerDepthChartPos(team.getRB1(), 1);
			setPlayerDepthChartPos(team.getRB2(), 2);
			setPlayerDepthChartPos(team.getRB3(), 3);
			setPlayerDepthChartPos(team.getWR1(), 1);
			setPlayerDepthChartPos(team.getWR2(), 2);
			setPlayerDepthChartPos(team.getWR3(), 3);
			setPlayerDepthChartPos(team.getWR4(), 4);
			setPlayerDepthChartPos(team.getWR5(), 5);
			setPlayerDepthChartPos(team.getTE1(), 1);
			setPlayerDepthChartPos(team.getTE2(), 2);
			setPlayerDepthChartPos(team.getK1(), 1);
			setPlayerDepthChartPos(team.getD(), 1);
		}
		
		
	}
	
	private void setPlayerDepthChartPos(String playerId, int depth) {
		Iterator<Player> players = playerList.iterator();
		Player player = null;
		while(players.hasNext()) {
			player = players.next();
			if(player.getPlayerId().equals(playerId)) {
				player.setDepthChartPosition(depth);
				break;
			}
		}
	}

	public void getPlayers() {
	  Document doc = null;

	  doc = parseXmlFile(Utils.PLAYERSURL, doc);
	  parsePlayerDocument(doc);
	  populatePostionLists();

	}

	public void getDepthCharts() {
	  Document doc = null;
	  doc = parseXmlFile(Utils.DEPTHURL, doc);
	  parseDepthChartDocument(doc);
	}

	private Document parseXmlFile(String URL, Document doc) {

		try {

			URL xmlUrl = new URL(URL);
			InputStream in = xmlUrl.openStream();
			doc = parse(in);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return doc;
	}

	private void parsePlayerDocument(Document doc) {
		Element docElement = doc.getDocumentElement();

		NodeList nl = docElement.getElementsByTagName(Utils.PLAYER);
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element element = (Element) nl.item(i);

				playerList.add(getPlayer(element));
			}
			Collections.sort(playerList, new PlayerComparator());
			Collections.sort(playerList, new TeamComparator());

		}
	}

	private void parseDepthChartDocument(Document doc) {
	  Element docElement = doc.getDocumentElement();
    
	  NodeList nl = docElement.getElementsByTagName(Utils.TEAM);
    if (nl != null && nl.getLength() > 0) {
      for (int i = 0; i < nl.getLength(); i++) {
        
        Element element = (Element) nl.item(i);
        
        teamList.add(getTeam(element));
      }
    }    
	}

	private Player getPlayer(Element element) {
		String firstName = "";
		String lastName = getTextValue(element, Utils.NAME);
		String id = getTextValue(element, Utils.ID);
		String position = getTextValue(element, Utils.POSITION);
		String team = getTextValue(element, Utils.TEAM);

		String names[] = lastName.split(",");

		if (names.length == 2) {
			firstName = names[1].trim();
			lastName = names[0].trim();
		}

		return new Player(id, firstName, lastName, position, team);
	}

	private String getTextValue(Element ele, String tagName) {
		String str = "";
		if (ele.getAttribute(tagName) != null
				&& !ele.getAttribute(tagName).equals("")) {
			str = ele.getAttribute(tagName);
		}

		return str.trim();
	}

	private Team getTeam(Element element) {

	  String id = getTextValue(element, Utils.ID); 
	  String QB1 = getTextValue(element, Utils.QB1);
	  String QB2 = getTextValue(element, Utils.QB2);
	  String QB3 = getTextValue(element, Utils.QB3);
	  String RB1 = getTextValue(element, Utils.RB1);
	  String RB2 = getTextValue(element, Utils.RB2);
	  String RB3 = getTextValue(element, Utils.RB3);
	  String WR1 = getTextValue(element, Utils.WR1);
	  String WR2 = getTextValue(element, Utils.WR2);
	  String WR3 = getTextValue(element, Utils.WR3);
	  String WR4 = getTextValue(element, Utils.WR4);
	  String WR5 = getTextValue(element, Utils.WR5);
	  String TE1 = getTextValue(element, Utils.TE1);
	  String TE2 = getTextValue(element, Utils.TE2);
	  String K = getTextValue(element, Utils.K1);
	  String D = getTextValue(element, Utils.D);

	  return new Team(id,QB1,QB2,QB3,RB1,RB2,RB3,WR1,WR2,WR3,WR4,WR5,TE1,TE2,K,D);
	}

	private void printTeamData() {
	   Iterator<Team> it = teamList.iterator();
		System.out.println("----------Start of Depth Chart stuff-----------");
	    while (it.hasNext()) {
	      System.out.println(it.next().toString());
	    }
	}

	private void printData() {

		Iterator<Player> it = qbs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("----------------------");
		it = rbs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("----------------------");
		it = wrs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("----------------------");
		it = tes.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("----------------------");
		it = ks.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("----------------------");
		it = def.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("----------------------");
	}

	public static Document parse(InputStream is) {
		Document ret = null;
		DocumentBuilderFactory domFactory;
		DocumentBuilder builder;

		try {
			domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setValidating(false);
			domFactory.setNamespaceAware(false);
			builder = domFactory.newDocumentBuilder();

			ret = builder.parse(is);
		} catch (Exception ex) {
			System.err.println("unable to load XML: " + ex);
		}
		return ret;
	}

	public void populatePostionLists() {

		for (int i = 0; i < playerList.size(); i++) {
			switch (posToInt(playerList.get(i).getPosition())) {
			case 0:
				qbs.add(playerList.get(i));
				break;
			case 1:
				rbs.add(playerList.get(i));
				break;
			case 2:
				wrs.add(playerList.get(i));
				break;
			case 3:
				tes.add(playerList.get(i));
				break;
			case 4:
				ks.add(playerList.get(i));
				break;
			case 5:
				def.add(playerList.get(i));
				break;
			}
		}
	}

	private int posToInt(String position) {
		int positionAsInt = 0;

		if (position.equals(Utils.QB)) {
			positionAsInt = 0;
		} else if (position.equals(Utils.RB))  {
			positionAsInt = 1;
		} else if (position.equals(Utils.WR))  {
			positionAsInt = 2;
		} else if (position.equals(Utils.TE))  {
			positionAsInt = 3;
		} else if (position.equals(Utils.PK))  {
			positionAsInt = 4;
		} else if (position.equals(Utils.DEF))  {
			positionAsInt = 5;
		} else {
			positionAsInt = 99;
		}

		return positionAsInt;
	}
}