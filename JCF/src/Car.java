import java.util.Comparator;

public class Car {
	private String name;
	private String color;
	private double price;

	public Car(String name, String color, double price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public void Show() {
		System.out.printf("Name: %s\tColor%s\tPrice: %f\n", name, color, price);
	}
}

class SortbyPrice implements Comparator<Car> 
{ 
    // Used for sorting in ascending order of 
    // roll number 

    public int compare(Car a, Car b) 
    { 
    	double price = a.getPrice() - b.getPrice();
    	//String str= String.valueOf(price);
        return (int)price;// Integer.parseInt(str); 
    } 
} 
