import java.util.Objects;

/**
 * Encapsulates a linked list of <code>String</code>.
 */
public abstract class ApplianceList {

	/** First node in linked list - dummy node */
	protected ApplianceNode first;

	/** Last node in linked list */
	protected ApplianceNode last;

	/** Number of data items in the list. */
	protected int length;

	public ApplianceList() {
		ApplianceNode n = new ApplianceNode(null);
		first = n;
		last = n;
		length = 0;
	}

	/**
	 * Gets the number of data values currently stored in this LinkedList.
	 * 
	 * @return the number of elements in the list.
	 */

	public int getLength() {
		return length;
	}

	/**
	 * Appends a String data element to this LinkedList.
	 * 
	 * @param /data
	 *            the data element to be appended.
	 */
	public void append(Appliance d) {
		// TODO Code here for append
		ApplianceNode newNode = new ApplianceNode(d);
		last.next = newNode;
		last = newNode;
		length++;
	} // method append(String)

	/**
	 * Prepends (adds to the beginning) a String data element to this
	 * LinkedList.
	 * 
	 * @param /data
	 *            the data element to be prepended.
	 */
	public void prepend(Appliance d) {
		// TODO Code here for prepend
		ApplianceNode newNode = new ApplianceNode(d);
		newNode.next = first.next;
		first.next = newNode;
		if (last == first) last = newNode;
		length++;
	} // method append(String)

	/**
	 * @return String representation of elements in linked list delimited by a
	 *         space character
	 */
	public String toString() {
		ApplianceNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " ";
			p = p.next;
		}
		return returnString;
	}

	/**
	 * Determines whether this ShortSequenceLinkedList is equal in value to the
	 * parameter object. They are equal if the parameter is of class
	 * ShortSequenceLinkedList and the two objects contain the same short
	 * integer values at each index.
	 * 
	 * @param other
	 *            the object to be compared to this ShortSequenceLinkedList
	 * 
	 * @return <code>true</code> if the parameter object is a
	 *         ShortSequenceLinkedList containing the same numbers at each index
	 *         as this ShortSequenceLinkedList, <code>false</code> otherwise.
	 */
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()
				|| length != ((ApplianceList) other).length)
			return false;

		ApplianceNode nodeThis = first;
		ApplianceNode nodeOther = ((ApplianceList) other).first;
		while (nodeThis != null) {
			// Since the two linked lists are the same length,
			// they should reach null on the same iteration.

			if (!Objects.equals(nodeThis.data, nodeOther.data))
				return false;

			nodeThis = nodeThis.next;
			nodeOther = nodeOther.next;
		} // while

		return true;
	} // method equals

} // class LinkedList

