import java.util.ArrayList;

public class AppointmentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appointments = new ArrayList<>();
		int option = 0;
		while (option != 4) {
			printMenu();
			option = Helper.readInt("Enter the option > ");

			if (option == 1) {
				addAppointment(appointments);
			} else if (option == 2) {
				viewAppointments(appointments);
			} else if (option == 3) {
				deleteAppointment(appointments);
			} else if (option == 4) {
				System.out.println("Quitting the application.");
			} else {
				System.out.println("Invalid option. Please select a valid option.");
			}
		}
	}

	public static void printMenu() {
		Helper.line(80, "-");
		System.out.println("Renovation Portal");
		Helper.line(80, "-");
		System.out.println("1. Add a new appointment");
		System.out.println("2. View all appointments");
		System.out.println("3. Delete an existing appointment");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void addAppointment(ArrayList<Appointment> appointments) {
		System.out.println("Add a new appointment:");
		String date = "";

		while (!isValidDate(date)) {
			date = Helper.readString("Enter the date (DD/MM/YYYY): ");

			if (!isValidDate(date)) {
				System.out.println("Invalid date format. Please use the format DD/MM/YYYY.");
			}
		}

		String time = Helper.readString("Enter the time: ");
		String description = Helper.readString("Enter the description: ");
		String customerid = Helper.readString("Enter customer id: ");

		Appointment appointment = new Appointment(date, time, description, customerid);
		appointments.add(appointment);

		System.out.println("Appointment added successfully.");
	}

	public static void viewAppointments(ArrayList<Appointment> appointments) {
		System.out.println("View all appointments:");
		if (appointments.isEmpty()) {
			System.out.println("No appointments found.");
		} else {
			for (int i = 0; i < appointments.size(); i++) {
				System.out.println("Appointment " + (i + 1) + ": " + appointments.get(i));
			}
		}
	}

	public static void deleteAppointment(ArrayList<Appointment> appointments) {
		System.out.println("Delete an existing appointment:");
		viewAppointments(appointments);

		int appointmentIndex = Helper.readInt("Enter the index of the appointment to delete: ") - 1;

		if (appointmentIndex >= 0 && appointmentIndex < appointments.size()) {
			appointments.remove(appointmentIndex);
			System.out.println("Appointment deleted successfully.");
		} else {
			System.out.println("Invalid appointment index.");
		}
	}

	public static boolean isValidDate(String date) {
		// Validate date format (DD/MM/YYYY) using regular expression
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
		return date.matches(regex);
	}
}
