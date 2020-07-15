package net.raabdev.java_practice.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Player john = new Player("John", "Pistol");
        System.out.println(john.toString());
        saveObject(john);

        System.out.println(john);
        john.setWeapon("Stormbringer");
        saveObject(john);
   //     loadObject(john);
        System.out.println(john);
        
        if(john instanceof Saveable) {
        	System.out.println("John is Saveable!");
        }
        
        Saveable sully = new Monster("Sully");
        System.out.println(sully);
        ((Monster) sully).setScary(false);
        System.out.println(sully);
        saveObject(sully);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(Saveable objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(Saveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}
