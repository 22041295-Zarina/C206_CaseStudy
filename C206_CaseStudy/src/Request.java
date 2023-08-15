public class Request {
	private String custID;
	private String requestDate;
	private String description;
	private String estimatedStartDate;
	private double budget;

	public Request(String custID, String requestDate, String description, String estimatedStartDate, double budget) {
		this.custID = custID;
		this.requestDate = requestDate;
		this.description = description;
		this.estimatedStartDate = estimatedStartDate;
		this.budget = budget;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEstimatedStartDate() {
		return estimatedStartDate;
	}

	public void setEstimatedStartDate(String estimatedStartDate) {
		this.estimatedStartDate = estimatedStartDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
}