/**
 * @author Jarred Morris
 * A Comparator to impose a total order on Weet objects according to their date.
 **/
public class TweetDateComparator implements Comparator<Tweet> {

	/**
	 * inheritDoc
	 * Orders the Weet objects by their Date posted
	 */
	public int compare(Tweet e1, Tweet e2) {
		// Compares the dates the weets were posted, and return this value
		return e1.getDate().compareTo(e2.getDate());
	}
}
