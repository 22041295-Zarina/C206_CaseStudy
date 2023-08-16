import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class C206_CaseStudy {
	private static List<ServiceProvider> serviceProviders;
    private static int nextId;
    
	private List<Quote> quotes = new ArrayList<>();

    private static boolean isValidDateFormat(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date parsedDate = sdf.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

    public C206_CaseStudy() {
    	nextId = 1;
        serviceProviders = new ArrayList<>();
    }
	
	public static void main(String[] args) {
		    ServiceProviderMain serviceProviderMain = new ServiceProviderMain();
		    serviceProviderMain.addSampleData(); // Adding initial sample data
		    
		 // ArrayLists
		    nextId = 1;
		    serviceProviders = new ArrayList<>();
		    ArrayList<Service> serviceList = new ArrayList<>();
	        List<Quote> quotes = new ArrayList<>();
	        Scanner scanner = new Scanner(System.in);
			List<Request> requests = new ArrayList<>();
			ArrayList<Appointment> appointments = new ArrayList<>();
			
			int option = 0;

			while (option != 20) {

				
				C206_CaseStudy.menu();
				option = Helper.readInt("Enter an option > ");
				
			
			if (option == 4) {
					scanner.nextLine(); // Clear the newline character
                    ServiceProvider newServiceProvider = inputServiceProvider();
                    addServiceProvider(newServiceProvider);
				}
				
				else if (option == 5) {
                    viewAllServiceProviders();
				}
				
				else if (option == 6) {
					System.out.print("Enter the ID of the service provider to delete: ");
                    int id = scanner.nextInt();
                    deleteServiceProvider(id);
				}

				else if (option == 7) {
					// Add a new service
					ServiceMain.setHeader("ADD NEW RENOVATION SERVICE");
					
					Service sv = inputNewService();
					if (addService(serviceList, sv)) {				
						// "New Renovation Service added" message is displayed
			            System.out.println("\nNew Renovation Service added!");
			        } else {
			            System.out.println("\nService addition failed");
			        }
					
				} else if (option == 8) {
					    // View all services
					    ServiceMain.setHeader("VIEW ALL SERVICES");

					    String allServices = viewAllServices(serviceList);
					    System.out.println(allServices);
					
				} else if (option == 9) {
					// Delete an existing service
			        
			        ServiceMain.setHeader("DELETE A SERVICE");

			        int serviceNumberToDelete = Helper.readInt("Enter Service Number to delete: ");
			        deleteService(serviceList, serviceNumberToDelete);
			        
			        // Print the updated list of services
			        ArrayList<Service> updatedServices = getExistingServices(serviceList);
			        for (Service service : updatedServices) {
			            System.out.println("Service Number: " + service.getNumber() + ", Name: " + service.getName());
			        }
			        
				} else if (option == 10) {
					int spid = Helper.readInt("Enter service provider id: ");
	                String responsedate = Helper.readString("Enter response date: ");
	                String description = Helper.readString("Enter quote's description: ");
	                double price = Helper.readDouble("Enter quote's price: ");
	                Quote quote = new Quote(spid, responsedate, description, price);
	                quotes.add(quote);
	                
				} else if (option == 11) {
					System.out.println("All Quotes:");
	                for (Quote quote : quotes) {
	                    System.out.println("Spid: " + quote.getSpid());
	                    System.out.println("Response date: " + quote.getResponsedate());
	                    System.out.println("Description: " + quote.getDescription());
	                    System.out.println("Price: $" + quote.getPrice());
	                    System.out.println();
	                }
	                
				} else if (option == 12) {
					int quoteIndex = Helper.readInt("Enter the index of the quote to delete: ");
	                if (quoteIndex >= 0 && quoteIndex < quotes.size()) {
	                    quotes.remove(quoteIndex);
	                    System.out.println("Quote deleted successfully!");
	                } else {
	                    System.out.println("Invalid index. No quote deleted.");
	                }
	                
				} else if (option == 13) {
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
						System.out.print("Enter esitimated start date date (DD/MM/YYYY): ");
						estimatedStartDate = scanner.nextLine();
						if (!isValidDateFormat(estimatedStartDate)) {
							System.out.println("Wrong date format. Please follow DD/MM/YYYY format.");
						}
					} while (!isValidDateFormat(estimatedStartDate));

					System.out.print("Enter Budget: ");
					double budget = scanner.nextDouble();

					requests.add(new Request(custID, requestDate, description, estimatedStartDate, budget));
					System.out.println("Request added successfully.");
					
				} else if (option == 14) {
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
					
				} else if (option == 15) {
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
					
				} else if (option == 16) {
					addAppointment(appointments);
				} else if (option == 17) {
					viewAppointments(appointments);
				} else if (option == 18) {
					deleteAppointment(appointments);
				}
		
			}
	}
		
			public static void menu() {
				ServiceMain.setHeader("RENOVATION PORTAL - Services");
	            System.out.println("1. ");
	            System.out.println("2. ");
	            System.out.println("3. ");
	            System.out.println("4. Add a new service provider");
	            System.out.println("5. View all service providers");
	            System.out.println("6. Delete an existing service provider");
	            System.out.println("7. Add Service");
				System.out.println("8. View all services");
				System.out.println("9. Delete an existing service");
	            System.out.println("10. Add a new quote");
	            System.out.println("11. View all quotes");
	            System.out.println("12. Delete an existing quote");
	            System.out.println("13. Add New Request");
				System.out.println("14. View All Requests");
				System.out.println("15. Delete Request");
				System.out.println("16. Add a new appointment");
				System.out.println("17. View all appointments");
				System.out.println("18. Delete an existing appointment");
				System.out.println("19. Exit");
				Helper.line(80, "-");
		    }

		    // Method to add initial sample data to the serviceProviders list
		    public void addSampleData() {
		        serviceProviders.add(new ServiceProvider(nextId++, "Shasha Renovation", "Kitchen Remodel", "shasharemodel@gmail.com", "1 Woodlands Square Singapore 738099", 3, "Kitchen Remodeling, Bathroom Renovation"));
		        serviceProviders.add(new ServiceProvider(nextId++, "Quick Plumbing", "Emergency plumbing services", "quickplumbing@gmail.com", "456 Tampines St 45 Singapore 520456", 5, "Plumbing Repairs, Drain Cleaning"));
		    }
		    
		    public static boolean isValidDate(String date) {
				// Validate date format (DD/MM/YYYY) using regular expression
				String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
				return date.matches(regex);
			}

			public static void setHeader(String header) {
				Helper.line(80, "-");
				System.out.println(header);
				Helper.line(80, "-");
			}
			
// ===================================================================================== Option 4 - Add new ServiceProvider ========================================================================================================================================================
		    // Add a new service provider
		    public static ServiceProvider inputServiceProvider() {
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
		        System.out.print("Enter services: ");
		        String services = scanner.nextLine();

		        return new ServiceProvider(nextId++, name, description, email, address, numberOfDesigners, services);
		    }

		    // Validate email format
		    public static boolean isValidEmail(String email) {
		        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		        Pattern pattern = Pattern.compile(emailRegex);
		        return pattern.matcher(email).matches();
		    }

		    // Add a service provider to the list
		    public static void addServiceProvider(ServiceProvider serviceProvider) {
		        if (serviceProvider.getName() == null || serviceProvider.getName().isEmpty() ||
		            serviceProvider.getDescription() == null || serviceProvider.getDescription().isEmpty() ||
		            serviceProvider.getAddress() == null || serviceProvider.getAddress().isEmpty()) {
		            System.out.println("Invalid input. Service provider not added.");
		            return;
		        }

		        serviceProviders.add(serviceProvider);
		        System.out.println("Service provider added.");
		    }
		    
// ===================================================================================== Option 5 - View all ServiceProvider ========================================================================================================================================================

		    // View all service providers
		    public static void viewAllServiceProviders() {
		        System.out.println("All Service Providers:");
		        for (ServiceProvider serviceProvider : serviceProviders) {
		            System.out.println(serviceProvider);
		            System.out.println("------------------------");
		        }
		    }
		    
// ===================================================================================== Option 6 - Delete ServiceProvider ========================================================================================================================================================

		    // Delete a service provider
		    public static void deleteServiceProvider(int id) {
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

		   

			public static String showAvailability(boolean isAvailable) {
				String avail;

				if (isAvailable == true) {
					avail = "Yes";
				} else {
					avail = "No";
				}
				return avail;
			}
			
			public static ArrayList<Service> getExistingServices(ArrayList<Service> serviceList) {
			    return (serviceList);
			}
			
// ===================================================================================== Option 7 Add an Service (CRUD - Create) ========================================================================================================================================================
			public static Service inputNewService() {
				
				// service number, name, description, pricing
			    int number = Helper.readInt("Enter service number > ");
			    String name = Helper.readString("Enter renovation service name > ");
			    String description = Helper.readString("Enter renovation service description > ");
			    double pricing = Helper.readDouble("Enter the pricing of service > $");

			    return new Service(number, name, description, pricing);
			}
			
			public static boolean addService(ArrayList<Service> serviceList, Service sv) {

				boolean valid = true;

				if (sv.getName().isEmpty()) {
					System.out.println("Name cannot be empty");
					valid = false;
				}
				
				for(Service rs: serviceList) {
					if (rs.getName().equalsIgnoreCase(sv.getName()) ) {
						System.out.println("\n Service exist");
						valid = false;	
					}
					
				}
				
				if(valid == true) {
						serviceList.add(sv);
				}
			
				return valid;
			}
			
// ===================================================================================== Option 8 View Services (CRUD - Read) ========================================================================================================================================================
			
			public static String viewAllServices(ArrayList<Service> serviceList) {
			    String header = "";
			    String output = "";
			    
			    header += String.format("%-20s %-20s %-20s %-10s\n", "SERVICE NUMBER", "NAME", "DESCRIPTION", "PRICE");
			    
			    if (serviceList.isEmpty()) {
			        output = "No services available.";
			    } else {
			        for (Service service : serviceList) {
			            output += String.format("%-20d %-20s %-20s %-10.2f\n", service.getNumber(), service.getName(), service.getDescription(), service.getPrice());
			        }
			    }
			    
			    return header + output;
			}


// ===================================================================================== Option 9 Delete Service (CRUD - Delete) ========================================================================================================================================================

			public static boolean deleteService(ArrayList<Service> serviceList, int serviceNumberToDelete) {
				
				char yesNo = Helper.readChar("Are you sure you want to delete service " + serviceNumberToDelete + "? (Y/N): ");
				if (yesNo == 'y' || yesNo == 'Y') {
					boolean isServiceDeleted = serviceList.removeIf(service -> service.getNumber() == serviceNumberToDelete);
				    
				    if (isServiceDeleted == true) {
				    	System.out.println("\nService Deleted!");
				    } else {
				    	System.out.println("\nService not found. Deletion Failed");
				    }
				} else {
					System.out.println("Deletion cancelled");
				}
				return false;
			
			}
			
// ===================================================================================== Option 10 Add Quote ========================================================================================================================================================

			public void addQuote(int spid, String responsedate, String description, double price) {
				Quote newQuote = new Quote(spid, responsedate, description, price);
				quotes.add(newQuote);
			}

// ===================================================================================== Option 11 View Quote ========================================================================================================================================================

			public List<Quote> getAllQuotes() {
				return new ArrayList<>(quotes);
			}
			
// ===================================================================================== Option 12 Delete Quote ========================================================================================================================================================

			public void deleteQuote(int quoteIndex) {
				if (quoteIndex >= 0 && quoteIndex < quotes.size()) {
					quotes.remove(quoteIndex);
				}
			}

			public Object viewAllQuotes() {
				return null;
			}
			
// ===================================================================================== Option 13 Add Request ========================================================================================================================================================
// ===================================================================================== Option 14 View Request ========================================================================================================================================================
// ===================================================================================== Option 15 Delete Request ========================================================================================================================================================

			
// ===================================================================================== Option 16 Add Appointment ========================================================================================================================================================
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
			
			
// ===================================================================================== Option 17 View Appointment ========================================================================================================================================================

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
			
// ===================================================================================== Option 18 Delete Appointment ========================================================================================================================================================

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

	}
