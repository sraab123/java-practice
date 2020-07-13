package net.raabdev.java_practice.oop1;

public class Floor {

	public Floor(double width, double length) {
		this.width = width;
		this.length = length;
	}

	private double width, length;

	public double getArea() {
		return length * width;
	}
	
}
