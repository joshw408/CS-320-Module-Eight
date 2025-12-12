//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025


package source;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    private static final AtomicLong SEQ = new AtomicLong(0);
    //Strings
    private final String contactID;   
    private String firstName;         
    private String lastName;          
    private String number;            
    private String address;           

    public Contact(String firstName, String lastName, String number, String address) {
        this.contactID = generateId();
        setFirstName(firstName);
        setLastName(lastName);
        setNumber(number);
        setAddress(address);
    }

    private static String generateId() {
        long n = SEQ.incrementAndGet();
     // Zero-pad to 10 chars
     // Pads with zeros to length 10
     // Ensures a 10-char zero-padded string
        String id = String.format("%010d", n);
        if (id.length() > 10) {
        	// Safety check; spec limits to 10
        	// Guard to enforce 10-char limit
        	// Enforces ≤10 per spec
            throw new IllegalStateException("Generated contact ID exceeds the 10 characters");
        }
        return id;
    }

    public String getContactID() { return contactID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNumber() { return number; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Error a firstName is required");
        if (firstName.length() > 10) throw new IllegalArgumentException("Error a firstName max length is 10");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Error a lastName is required");
        if (lastName.length() > 10) throw new IllegalArgumentException("Error a lastName max length is 10");
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        if (number == null) throw new IllegalArgumentException("Error a phone number is required");
        if (!number.matches("\\d{10}")) throw new IllegalArgumentException("Error a phone must be exactly 10 digits");
        this.number = number;
    }

    public void setAddress(String address) {
        if (address == null) throw new IllegalArgumentException("Error an address is required");
        if (address.length() > 30) throw new IllegalArgumentException("Error an address max length is 30");
        this.address = address;
    }
}
