package net.raabdev.java_practice.generics;

public class Team<T> implements Comparable<Team<T>>{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	private String name;
	private int points;
	@Override
	public int compareTo(Team<T> team) {		
		return team.points - this.points;
	}
	public Team(String name, int points) {
		this.name = name;
		this.points = points;
		
	}
	@Override
	public String toString() {
		return "Team [Name=" + name + ", points=" + points + "]";
	}
	

}
