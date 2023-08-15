public class Appointment {
  
  private String date;
    private String time;
    private String description;
    private String customerid;
    public Appointment(String date, String time, String description, String customerid) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.customerid = customerid;
    }

    public String toString() {
        return "Date: " + date + ", Time: " + time + ", Description: " +
    description + ", Customer id: " + customerid;
    }

}