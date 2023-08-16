import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RequestMain {

    public static final Scanner scanner = new Scanner(System.in);
    public static final List<Request> requests = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add New Request");
            System.out.println("2. View All Requests");
            System.out.println("3. Delete Request");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addNewRequest();
                    break;
                case 2:
                    viewAllRequests();
                    break;
                case 3:
                    deleteRequest();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    public static void addNewRequest() {
        System.out.print("Customer ID: ");
        String custID = scanner.nextLine();
        String requestDate;
        do {
            System.out.print("Enter request date (DD/MM/YYYY): ");
            requestDate = scanner.nextLine();
            if (!isValidDateFormat(requestDate)) {
                System.out.println("Wrong date format. Please follow DD/MM/YYYY format.");
            }
        } while (!isValidDateFormat(requestDate));
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        String estimatedStartDate;
        do {
            System.out.print("Enter estimated start date (DD/MM/YYYY): ");
            estimatedStartDate = scanner.nextLine();
            if (!isValidDateFormat(estimatedStartDate)) {
                System.out.println("Wrong date format. Please follow DD/MM/YYYY format.");
            }
        } while (!isValidDateFormat(estimatedStartDate));

        System.out.print("Enter Budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        requests.add(new Request(custID, requestDate, description, estimatedStartDate, budget));
        System.out.println("Request added successfully.");
    }

    public static List<Request> viewAllRequests() {
        if (requests.isEmpty()) {
            System.out.println("No requests found.");
        } else {
            System.out.println("List of Requests:");
            for (int i = 0; i < requests.size(); i++) {
                Request request = requests.get(i);
                System.out.println("Request " + (i + 1));
                System.out.println("Customer ID: " + request.getCustID());
                System.out.println("Request Date: " + request.getRequestDate());
                System.out.println("Description: " + request.getDescription());
                System.out.println("Estimated Start Date: " + request.getEstimatedStartDate());
                System.out.println("Budget: " + request.getBudget());
                System.out.println("----------------------");
            }
        }
        return requests;
    }

    public static void deleteRequest() {
        if (requests.isEmpty()) {
            System.out.println("No requests to delete.");
        } else {
            System.out.print("Enter the index of the request to delete: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (index >= 1 && index <= requests.size()) {
                System.out.print("Are you sure you want to delete this request? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {
                    requests.remove(index - 1);
                    System.out.println("Request deleted successfully.");
                } else {
                    System.out.println("Request deletion canceled.");
                }
            } else {
                System.out.println("Invalid request index.");
            }
        }
    }

    public static boolean isValidDateFormat(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date parsedDate = sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
