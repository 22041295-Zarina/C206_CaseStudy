
public class Quote {
	private int spid;
	private String responsedate;
	private String description;
	private double price;

	public Quote(int spid, String responsedate, String description, double price) {
		this.spid = spid;
		this.responsedate = responsedate;
		this.description = description;
		this.price = price;
	}

	public int getSpid() {
		return spid;
	}

	public String getResponsedate() {
		return responsedate;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
}
