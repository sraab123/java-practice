package net.raabdev.java_practice.oop1;

public class Calculator {
	private Floor floor;
	private Carpet carpet;

	public Calculator(Floor floor, Carpet carpet) {
		this.floor = floor;
		this.carpet = carpet;
	}
 
	public double getTotalCost() {
		return carpet.getCost() * floor.getArea();
	}
}
