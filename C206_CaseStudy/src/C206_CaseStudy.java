import java.util.ArrayList;

public class C206_CaseStudy {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Service> serviceList = new ArrayList<>();
		
		int option = 0;

		while (option != 3) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 7) {
				// Add a new service
				C206_CaseStudy.setHeader("ADD NEW RENOVATION SERVICE");
				
				Service sv = inputNewService();
				if (addService(serviceList, sv)) {				
					// "New Renovation Service added" message is displayed
		            System.out.println("\nNew Renovation Service added!");
		        } else {
		            System.out.println("\nService addition failed");
		        }
				
			} else if (option == 8) {
				    // View all services
				    C206_CaseStudy.setHeader("VIEW ALL SERVICES");

				    String allServices = viewAllServices(serviceList);
				    System.out.println(allServices);
				
			} else if (option == 9) {
				// Delete an existing service
		        
		        C206_CaseStudy.setHeader("DELETE A SERVICE");

		        int serviceNumberToDelete = Helper.readInt("Enter Service Number to delete: ");
		        deleteService(serviceList, serviceNumberToDelete);
		        
		        // Print the updated list of services
		        ArrayList<Service> updatedServices = getExistingServices(serviceList);
		        for (Service service : updatedServices) {
		            System.out.println("Service Number: " + service.getNumber() + ", Name: " + service.getName());
		        }
			}
		}
		}

		public static void menu() {
			C206_CaseStudy.setHeader("RENOVATION PORTAL - Services");
			System.out.println("7. Add Service");
			System.out.println("8. View all services");
			System.out.println("9. Delete an existing service");
			Helper.line(80, "-");
		}
		
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
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

		//================================= Option 7 Add an Service (CRUD - Create) =================================
		public static Service inputNewService() {
			
			// service number, name, description, pricing
		    int number = Helper.readInt("Enter service number > ");
		    String name = Helper.readString("Enter renovation service name > ");
		    String description = Helper.readString("Enter renovation service description > ");
		    double pricing = Helper.readDouble("Enter the pricing of service > $");

		    return new Service(number, name, description, pricing);
		}
		
		public static boolean addService(ArrayList<Service> serviceList, Service sv) {

			for(Service rs: serviceList) {
				if (rs.getName().equalsIgnoreCase(sv.getName()) )
					System.out.println("\n Service exist");; // Service exists
			}
			
			serviceList.add(sv);
			return true;
		}
		
		//================================= Option 8 View Services (CRUD - Read) =================================
		public static String viewAllServices(ArrayList<Service> serviceList) {
			String header = "";
		    String output = "";
		    
		    if (serviceList.isEmpty()) {
		        output = "No services available.";
		    } else {
		        for (Service service : serviceList) {
		        	header += String.format("%-20s %-20s %-20s %-10s\n", "SERVICE NUMBER", "NAME", "DESCRIPTION", "PRICE");
		            output += String.format("%-20d %-20s %-20s %-10.2f\n", service.getNumber(), service.getName(), service.getDescription(), service.getPrice());
		        }
		    }
		    
		    return header + output;
		}


		//================================= Option 9 Delete Service (CRUD - Delete) =================================
		public static void deleteService(ArrayList<Service> serviceList, int serviceNumberToDelete) {
			
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
		
		}

}
