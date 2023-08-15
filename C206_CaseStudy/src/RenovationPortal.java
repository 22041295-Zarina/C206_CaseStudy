import java.util.ArrayList;
import java.util.List;

public class RenovationPortal {
	private List<Quote> quotes = new ArrayList<>();

	public void addQuote(int spid, String responsedate, String description, double price) {
		Quote newQuote = new Quote(spid, responsedate, description, price);
		quotes.add(newQuote);
	}

	public List<Quote> getAllQuotes() {
		return new ArrayList<>(quotes);
	}

	public void deleteQuote(int quoteIndex) {
		if (quoteIndex >= 0 && quoteIndex < quotes.size()) {
			quotes.remove(quoteIndex);
		}
	}

	public Object viewAllQuotes() {
		// TODO Auto-generated method stub
		return null;
	}

}