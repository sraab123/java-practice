package net.raabdev.java_practice.generics;

public class Main {

	public static void main(String[] args) {
		Team<Tennis> team1 = new Team<Tennis>("Rackets", 5);
		Team<Football> team2 = new Team<Football>("Bears", 10);
		Team<Football> team3 = new Team<Football>("Giants", 1);
		Team<Football> team4 = new Team<Football>("Saints", 100);
		Team<Football> team5 = new Team<Football>("Bucs", 1000);		
		Team<Football> team6 = new Team<Football>("Bears", 20);
		
		League<Football> nfl = new League<Football>();
		
		//nfl.addTeam(team1);
		nfl.addTeam(team2);
		nfl.addTeam(team3);
		nfl.addTeam(team4);
		nfl.addTeam(team5);
		nfl.addTeam(team6);
		
		nfl.showRankings();
	}
} 
