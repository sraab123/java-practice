package net.raabdev.java_practice.oop1;

import junit.framework.TestCase;

public class PointTest extends TestCase {

	public void testDistance() {
		Point p = new Point();
		assert(p.distance(-1,-1) == Math.sqrt(2));
	}

	public void testDistanceIntInt() {
		assert(true);
	}

	public void testDistancePoint() {
		assert(true);
	}

}
