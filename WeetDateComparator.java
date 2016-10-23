/**
 * @author Jarred Morris
 * A Comparator to impose a total order on Weet objects according to their date.
 **/
public class WeetDateComparator implements Comparator<Weet> {

	/**
	 * inheritDoc
	 * Orders the Weet objects by their Date posted
	 */
	public int compare(Weet e1, Weet e2) {
		// Compares the dates the weets were posted, and return this value
		return e1.getDate().compareTo(e2.getDate());
	}
}

class Weet {
	public Integer getDate() {
		return 0;
	}
}
