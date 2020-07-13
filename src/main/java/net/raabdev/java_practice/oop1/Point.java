package net.raabdev.java_practice.oop1;

public class Point {
private int x, y;

public Point() {
	
}

public Point(int x, int y) {
	this.setX(x);
	this.setY(y);
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public double distance() {
	return distance(0,0);
}

public double distance(int x, int y) {
	return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y)*(y - this.y));
}

public double distance(Point p) {
	return distance(p.getX(), p.getY());
}
}
