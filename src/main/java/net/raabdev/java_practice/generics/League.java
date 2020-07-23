package net.raabdev.java_practice.generics;

import java.util.ArrayList;
import java.util.Collections;

public class League<T> {
	
	private ArrayList<Team<T>> league = new ArrayList<>();

	public boolean addTeam(Team<T> newTeam) {
		for(Team<T> team: league) {
			if(newTeam.getName().equals(team.getName())) {
				System.out.println("Team " + newTeam.getName() + " already exists. Add operation failed.");
			    return false;
		}}
		league.add(newTeam);
		System.out.println("Added " + newTeam.getName() + " successfully." );
		Collections.sort(league);
		return true;
	}
	
	public void showRankings() {
		for(int i = 0; i < league.size(); i++) {
			System.out.println(league.get(i));
		} 
	}
}
