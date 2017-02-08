package seedu.addressbook.data.person;

public class Contact {
	public final String value;
	private boolean isPrivate;
	
	public Contact(String value, boolean isPrivate) {
		this.isPrivate = isPrivate;
		this.value = value;
	}
	
	public String toString() {
        return value;
    }

	public boolean isPrivate() {
        return isPrivate;
    }
}
