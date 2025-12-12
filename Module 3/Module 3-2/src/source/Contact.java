//Joshua Williamson
//CS-320
//Module 3-2
//November 14th, 2025


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
        // zero-pad to 10 characters; guarantees length <= 10 for a very long time
        String id = String.format("%010d", n);
        if (id.length() > 10) {
            // Safety guard; spec requires <= 10
            throw new IllegalStateException("Generated contact ID exceeds 10 characters");
        }
        return id;
    }

    public String getContactID() { return contactID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNumber() { return number; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Error firstName is required");
        if (firstName.length() > 10) throw new IllegalArgumentException("Error firstName max length is 10");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Error lastName is required");
        if (lastName.length() > 10) throw new IllegalArgumentException("Error lastName max length is 10");
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        if (number == null) throw new IllegalArgumentException("Error phone number is required");
        if (!number.matches("\\d{10}")) throw new IllegalArgumentException("Error phone must be exactly 10 digits");
        this.number = number;
    }

    public void setAddress(String address) {
        if (address == null) throw new IllegalArgumentException("Error address is required");
        if (address.length() > 30) throw new IllegalArgumentException("Error address max length is 30");
        this.address = address;
    }
}
