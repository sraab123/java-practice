package net.raabdev.java_practice.interfaces;

import java.util.List;

public interface Saveable {
	//saves the list
 public void read(List<String> savables);
   //returns the saved values
 public List<String> write();
}
