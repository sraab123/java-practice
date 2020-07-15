package net.raabdev.java_practice.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable {
	private String name;
	private String weapon;
	
	@Override
	public void read(List<String> values) {
		if(values != null && values.size() > 0) {
			this.name = values.get(0);
		    this.weapon = values.get(1);
		}
	}

	public Player(String name, String weapon) {
		super();
		this.name = name;
		this.weapon = weapon;
	}

	@Override
	public List<String> write() {
		List<String> values = new ArrayList<String>();
		values.add(name);
		values.add(weapon);
		return values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", weapon=" + weapon + "]";
	}

	
}
