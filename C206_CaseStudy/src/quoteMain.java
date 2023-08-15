import java.util.ArrayList;
import java.util.List;
//create quote main
public class quoteMain {
    public static void main(String[] args) {
        List<Quote> quotes = new ArrayList<>();

        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new quote");
            System.out.println("2. View all quotes");
            System.out.println("3. Delete an existing quote");
            System.out.println("4. Exit");

            choice = Helper.readInt("Enter a choice:");

            if (choice == 1) {
                int spid = Helper.readInt("Enter service provider id: ");
                String responsedate = Helper.readString("Enter response date: ");
                String description = Helper.readString("Enter quote's description: ");
                double price = Helper.readDouble("Enter quote's price: ");
                Quote quote = new Quote(spid, responsedate, description, price);
                quotes.add(quote);
            } else if (choice == 2) {
                System.out.println("All Quotes:");
                for (Quote quote : quotes) {
                    System.out.println("Spid: " + quote.getSpid());
                    System.out.println("Response date: " + quote.getResponsedate());
                    System.out.println("Description: " + quote.getDescription());
                    System.out.println("Price: $" + quote.getPrice());
                    System.out.println();
                }
            } else if (choice == 3) {
                int quoteIndex = Helper.readInt("Enter the index of the quote to delete: ");
                if (quoteIndex >= 0 && quoteIndex < quotes.size()) {
                    quotes.remove(quoteIndex);
                    System.out.println("Quote deleted successfully!");
                } else {
                    System.out.println("Invalid index. No quote deleted.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting Renovation Portal. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);
    }
}