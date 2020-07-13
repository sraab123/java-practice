package net.raabdev.java_practice.scanner;

public class PaintJob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
		if ( width <= 0
		|| height <= 0
		|| areaPerBucket <= 0
		|| extraBuckets < 0)
		return -1;
		
		double areaToPaint = width * height;
		
		int bucketsNeeded = (int) Math.ceil(areaToPaint / areaPerBucket);
		
		return bucketsNeeded - extraBuckets;
	}
	
	public static int getBucketCount(double width, double height, double areaPerBucket) {
	   return getBucketCount(width, height, areaPerBucket, 0);
    }
	
	public static int getBucketCount(double areaOfWall, double areaPerBucket) {
		   return getBucketCount(areaOfWall, 1.0, areaPerBucket, 0);
	    }
	
}
