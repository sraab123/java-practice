package net.raabdev.java_practice.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Saveable {
	private String name;
	private boolean isScary;
	private boolean isUnderBed;
	
	@Override
	public String toString() {
		return "Monster [name=" + name + ", isScary=" + isScary + ", isUnderBed=" + isUnderBed + "]";
	}

	public Monster(String name) {
		super();
		this.name = name;
		this.isScary = true;
		this.isUnderBed = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isScary() {
		return isScary;
	}

	public void setScary(boolean isScary) {
		this.isScary = isScary;
	}

	public boolean isUnderBed() {
		return isUnderBed;
	}

	public void setUnderBed(boolean isUnderBed) {
		this.isUnderBed = isUnderBed;
	}

	@Override
	public void read(List<String> values) {
		if(values != null && values.size() > 0) {
			this.name = values.get(0);
		    this.isScary = Boolean.valueOf(values.get(1));
		    this.isUnderBed = Boolean.valueOf(values.get(2));
		}
	}

	@Override
	public List<String> write() {
		ArrayList<String> values = new ArrayList<>();
		values.add(this.name);
		values.add(Boolean.toString(this.isScary));
		values.add(Boolean.toString(this.isUnderBed));
		return values;
	}

}
