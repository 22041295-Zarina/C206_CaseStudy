import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceJUnit {
	private Service s1;
	private Service s2;
	
	private ArrayList<Service> serviceList;
	
	@Before
	public void setUp() throws Exception {
		s1 = new Service(1, "Wall painting", "Wall painting service", 100.0);
		s2 = new Service(2, "Kitchen", "Kitchen Reno", 100.0);
		
		serviceList = new ArrayList<Service>();
	}
	
	@Test
	public void testAddService() {
	    // Item list is not null and it is empty
	    assertNotNull("Test if there is a valid Service arraylist to add to", serviceList);
	    assertEquals("Test that the Service arraylist is empty.", 0, serviceList.size());

	    // Given an empty list, after adding 1 item, the size of the list is 1
	    ServiceMain.addService(serviceList, s1);
	    assertEquals("Test that the Service arraylist size is 1.", 1, serviceList.size());

	    // Add an item
	    ServiceMain.addService(serviceList, s2);
	    assertEquals("Test that the Service arraylist size is now 2.", 2, serviceList.size());

	    // The item just added is the same as the last item in the list
	    assertSame("Test that Service is added to the end of the list.", s2, serviceList.get(1));

	    // Add an item that already exists in the list
	    ServiceMain.addService(serviceList, s2);
	    assertEquals("Test that the added service is already in the Service arraylist.", 2, serviceList.size());

	    // Add an item that has missing detail
	    Service ss_missing = new Service(3, "", "Living Room Reno", 100.0);
	    ServiceMain.addService(serviceList, ss_missing);
	    
	    // The size of the list should still be 2 after attempting to add a service with missing details
	    assertEquals("Test that the Service arraylist size is unchanged.", 2, serviceList.size());
	}

	@Test
	public void testViewAllServices() { 
	    // Test if Item list is not null but empty
	    assertNotNull("Test if there is valid service arraylist to retrieve services", serviceList);
	    
	    // Given an empty list, after adding 2 items, test if the size of the list is 2
	    serviceList.add(s1);
	    serviceList.add(s2);
	    assertEquals("Test that Service arraylist size is 2", 2, serviceList.size());
	    
	    // Test if the expected output string is same as the list of Service retrieved from the Useraccount 
	    String allServices = ServiceMain.viewAllServices(serviceList);
	    String allServicesOutput = String.format("%-10d %-30s %-30s %-10.2f\n", 1, "Wall painting", "Wall painting service", 100.0);
	 
	 
	    assertEquals("Test that ViewAllServices", allServicesOutput, allServices);
	}
	
	@Test
	public void testRemoveService() {
	    // Add some services to the list to have items for removal
	    serviceList.add(s1);
	    serviceList.add(s2);

	    // Before removal, the size of the list is 2
	    assertEquals("Check that Service arraylist size is 2", 2, serviceList.size());

	    // Remove the first service s1 and check if the arraylist size is reduced by 1
        boolean isRemovedS1 = ServiceMain.deleteService(serviceList, 0);
        assertTrue("Test if s1 is successfully removed.", isRemovedS1);
        assertEquals("Check that Service arraylist size is 1 after removal", 1, serviceList.size());

        // Check that the removed service s1 is no longer in the list
        assertFalse("Check that s1 is removed from the list", serviceList.contains(s1));

        // Remove the second service s2 and check if the list contain one item 
        boolean isRemovedS2 = ServiceMain.deleteService(serviceList, 1);
        assertTrue("Test if s2 is successfully removed.", isRemovedS2);
        assertEquals("Check that Service arraylist size is 0 after removal", 0, serviceList.size());

        // Check that the removed service s2 is no longer in the list
        assertFalse("Check that s2 is removed from the list", serviceList.contains(s2));
    }
	
	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		serviceList = null;
	}

}