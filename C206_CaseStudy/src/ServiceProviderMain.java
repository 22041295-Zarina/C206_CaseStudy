import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ServiceProviderMain {
    private List<ServiceProvider> serviceProviders;
    private int nextId;

    public ServiceProviderMain() {
    	nextId = 1;
        serviceProviders = new ArrayList<>();
    }

    // Method to add initial sample data to the serviceProviders list
    public void addSampleData() {
        serviceProviders.add(new ServiceProvider(nextId++, "Shasha Renovation", "Kitchen Remodel", "shasharemodel@gmail.com", "1 Woodlands Square Singapore 738099", 3, "Kitchen Remodeling, Bathroom Renovation"));
        serviceProviders.add(new ServiceProvider(nextId++, "Quick Plumbing", "Emergency plumbing services", "quickplumbing@gmail.com", "456 Tampines St 45 Singapore 520456", 5, "Plumbing Repairs, Drain Cleaning"));
    }

    // Add a new service provider
    public ServiceProvider inputServiceProvider() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please try again.");
            }
        } while (!isValidEmail(email));
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter number of designers: ");
        int numberOfDesigners = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character
        System.out.print("Enter services:");
        String services = scanner.nextLine();

        return new ServiceProvider(nextId++, name, description, email, address, numberOfDesigners, services);
    }

    // Validate email format
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Add a service provider to the list
    public void addServiceProvider(ServiceProvider serviceProvider) {
        if (serviceProvider.getName() == null || serviceProvider.getName().isEmpty() ||
            serviceProvider.getDescription() == null || serviceProvider.getDescription().isEmpty() ||
            serviceProvider.getAddress() == null || serviceProvider.getAddress().isEmpty()) {
            System.out.println("Invalid input. Service provider not added.");
            return;
        }

        serviceProviders.add(serviceProvider);
        System.out.println("Service provider added.");
    }

    // View all service providers
    public void viewAllServiceProviders() {
        System.out.println("All Service Providers:");
        for (ServiceProvider serviceProvider : serviceProviders) {
            System.out.println(serviceProvider);
            System.out.println("------------------------");
        }
    }

    // Delete a service provider
    public void deleteServiceProvider(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to delete this service provider? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("yes")) {
            Iterator<ServiceProvider> iterator = serviceProviders.iterator();
            while (iterator.hasNext()) {
                ServiceProvider serviceProvider = iterator.next();
                if (serviceProvider.getId() == id) {
                    iterator.remove();
                    System.out.println("Service provider with ID " + id + " deleted.");
                    return;
                }
            }
            System.out.println("Service provider with ID " + id + " not found.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // Method to display the menu options
    public void displayOptionsMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Service Provider Management System");
            System.out.println("1. Add a new service provider");
            System.out.println("2. View all service providers");
            System.out.println("3. Delete an existing service provider");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                ServiceProvider newServiceProvider = inputServiceProvider();
                addServiceProvider(newServiceProvider);
            } else if (choice == 2) {
                viewAllServiceProviders();
            } else if (choice == 3) {
                System.out.print("Enter the ID of the service provider to delete: ");
                int id = scanner.nextInt();
                deleteServiceProvider(id);
            } else if (choice == 4) {
                System.out.println("Exiting.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 4);
    }
  

    public static void main(String[] args) {
        ServiceProviderMain serviceProviderMain = new ServiceProviderMain();
        serviceProviderMain.addSampleData(); // Adding initial sample data
        serviceProviderMain.displayOptionsMenu();
    }
    
    // Method to get the list of service providers
    public List<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

}
