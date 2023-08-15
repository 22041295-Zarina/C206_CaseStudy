import java.util.ArrayList;

public class Service  {

	private int number;
	private String name;
    private String description;
    public double price;

    public Service(int number, String name, String description, double price) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    public String toString() {
        return "\nService Number: " + number + "\nName: " + name + "\nDescription: " + description + "\nPrice: $" + price;
    }

	public void setName(String newName) {
		this.name = newName;
	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

}
