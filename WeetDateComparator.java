/**
 * @author Jarred Morris
 * A Comparator to impose a total order on Tweet objects according to their date.
 **/
public class TweetDateComparator implements Comparator<Tweet> {

	/**
	 * inheritDoc
	 * Orders the Tweet objects by their Date posted
	 */
	public int compare(Tweet e1, Tweet e2) {
		// Compares the dates the tweets were posted, and return this value
		return e1.getDate().compareTo(e2.getDate());
	}
}
