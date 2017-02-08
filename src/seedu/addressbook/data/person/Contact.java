package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
	public final String value;
	private boolean isPrivate;
	
	public Contact(String value, boolean isPrivate, String regex, String constraintsMessage) throws IllegalValueException {
		this.isPrivate = isPrivate;
		String trimmedValue = value.trim();
        if (!isValid(trimmedValue, regex)) {
            throw new IllegalValueException(constraintsMessage);
        }
        this.value = trimmedValue;
	}
	
	public String toString() {
        return value;
    }
	
	public int hashCode() {
        return value.hashCode();
    }

	public boolean isPrivate() {
        return isPrivate;
    }
	
	public static boolean isValid(String test, String regex) {
        return test.matches(regex);
    }
}
