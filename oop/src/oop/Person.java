package oop;

public class Person {
	protected String name;
	protected String lastname;
	
	public Person(String name, String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void displayInfo() {
		System.out.println(name + " " + lastname);
		
	}
	
	
}
