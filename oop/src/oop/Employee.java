package oop;

public class Employee extends Person implements ShowInfo {
	
	private String company;

	public Employee(String name, String lastname, String company) {
		super(name, lastname);
		this.company=company;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void showPeter() {
		super.displayInfo();
		System.out.println("company -> "+ company);
		
	}

}
