package net.raabdev.java_practice.arrays_and_lists;

public class Contact {
	private String name;
	private String phone;
	
	public Contact() {
	}

	public Contact(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass() == Contact.class) {
		     Contact c = (Contact) o;
		     if(c.getName() == this.getName()) {
		    	 return true;
		     }
		}
		return false;
	}
}
