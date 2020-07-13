package net.raabdev.java_practice.oop1;

public class ComplexNumber {

	private double real;
	private double imaginary;

	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	public double getReal() {
		return real;
	}
	public double getImaginary() {
		return imaginary;
	}
	
	public void add(double real, double imaginary) {
		this.real+= real;
		this.imaginary+= imaginary;
	}
	
	public void add(ComplexNumber c) {
		this.add(c.getReal(), c.getImaginary());
	}
	
	public void subtract(double real, double imaginary) {
		this.real-= real;
		this.imaginary-= imaginary;
	}
	
	public void subtract(ComplexNumber c) {
		this.subtract(c.getReal(), c.getImaginary());
	}


}
