package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";

    private boolean isPrivate;
    
    private BlockNum blockNum;
    private StreetNum streetNum;
    private UnitNum unitNum;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressArr = trimmedAddress.split(",");
        blockNum = new BlockNum(addressArr[0]);
        streetNum = new StreetNum(addressArr[1]);
        unitNum = new UnitNum(addressArr[2]);
        postalCode = new PostalCode(addressArr[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return blockNum.getBlockNum() + ", " + streetNum.getStreetNum() + ", " + 
        		unitNum.getUnitNum() + ", " + postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    private class BlockNum {
    	String blockNum;
    	public BlockNum(String blockNum) {
    		this.blockNum = blockNum;
    	}
    	
    	//accessor
    	public String getBlockNum() {
    		return blockNum;
    	}
    }
    
    private class StreetNum {
    	String streetNum;
    	public StreetNum(String streetNum) {
    		this.streetNum = streetNum;
    	}
    	
    	//accessor
    	public String getStreetNum() {
    		return streetNum;
    	}
    }
    
    private class UnitNum {
    	String unitNum;
    	public UnitNum(String unitNum) {
    		this.unitNum = unitNum;
    	}
    	
    	//accessor
    	public String getUnitNum() {
    		return unitNum;
    	}
    }
    
    private class PostalCode {
    	String postalCode;
    	public PostalCode(String postalCode) {
    		this.postalCode = postalCode;
    	}
    	
    	//accessor
    	public String getPostalCode() {
    		return postalCode;
    	}
    }
}
