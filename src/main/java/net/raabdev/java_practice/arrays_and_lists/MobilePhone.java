package net.raabdev.java_practice.arrays_and_lists;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

	ArrayList<Contact> contacts = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	
	public MobilePhone() {
	}
	
	public void addContact(String name, String number) {
		contacts.add(new Contact(name, number));
	}
	
	public boolean removeContact(String name) {
		Contact c = findContact(name);
		if(c != null) {
		  contacts.remove(c);
		  return true;
		} else {
		  return false;
		}
	}
	
	public boolean updateContact(String oldName, String newName, String newPhone) {
		Contact c = findContact(oldName);
		if(c != null) {
		  c.setName(newName);
		  c.setPhone(newPhone);
		  return true;
		} else {
		  return false;
		}
	}
	
	public Contact findContact(String name) {
		for(Contact contact: contacts) {
			if(contact.getName().equals(name)) {
				return contact;
			}
		
		}
		return null;
	}

		
	public void showAllContacts() {
		if (contacts.size() > 0) {
		for(int i = 1; i <= contacts.size(); i++) {
			Contact c = contacts.get(i - 1);
			System.out.println(i + ".");
			System.out.println("Name: " + c.getName());
			System.out.println("Phone: " + c.getPhone());
			System.out.println("");
		}
	} else {
		System.out.println("No Contacts");
	}
	}
	
	public void optionMenu() {
		System.out.println("Phone Menu: ");
		System.out.println("1: Add a new contact ");
		System.out.println("2: Search for contact");
		System.out.println("3: Modify contact");
		System.out.println("4: Remove contact");
		System.out.println("5: Show all contacts");
		System.out.println("6: Quit");
	}
	
	public static void main(String[] args) {
		MobilePhone mp = new MobilePhone();
		boolean exit = false;
		
		while(!exit) {
			mp.optionMenu();
			String name;
			String phone;
			Contact contact;
			
			if(scanner.hasNextInt()) {
				
				switch(scanner.nextInt()) {
				case 1:
					System.out.println("New name: ");
					scanner.nextLine();
					name = scanner.nextLine();
					System.out.println("New Phone: ");
					phone = scanner.nextLine();
					mp.addContact(name, phone);
					System.out.println("Contact added: " + name + " " + phone);
					break;
					
				case 2:
					System.out.println("Contact name: ");
					scanner.nextLine();
					name = scanner.nextLine();
					contact = mp.findContact(name);
					if(contact == null) {
						System.out.println("Contact not found");
					} else {
						System.out.println("Found: " + contact.getName() + " " + contact.getPhone());
					}
					break;
					
				case 3:
					System.out.println("Old Contact Name: ");
					scanner.nextLine();
					String oldName = scanner.nextLine();
					System.out.println("Update Contact Name: ");
					name = scanner.nextLine();
					System.out.println("Update Contect Phone: ");
					phone = scanner.nextLine();
					if (mp.updateContact(oldName, name, phone)) {
						System.out.println("Contact Updated");
					} else {
						System.out.println("Contact Not Found");
					}
					break;
					
				case 4:
					System.out.println("Contact name: ");
					scanner.nextLine();
					name = scanner.nextLine();
					if(mp.removeContact(name)) {
						System.out.println("Contact Removed");
					} else {
						System.out.println("Contact Not Found");
					}
					break;
					
				case 5:
					mp.showAllContacts();
					break;
					
				case 6:
				default:	
					exit = true;
					break;
				}
				
				System.out.println("");
				
			} else {
				break;
			}
		}
	}

}
