//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025

package source;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

 // Adds a contact and returns its unique ID
 // Creates a new contact and returns its ID
 // Inserts a contact and returns the generated ID
    public String addContact(String firstName, String lastName, String number, String address) {
        Contact c = new Contact(firstName, lastName, number, address);
        String id = c.getContactID();
        if (contacts.containsKey(id)) {
            throw new IllegalStateException("Duplicate contact ID generated");
        }
        contacts.put(id, c);
        return id;
    }

 // Deletes by ID; returns true if found
 // Removes contact by ID; true if it existed
 // Delete contact by ID; returns true on success
    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

 // Gets contact by ID, or null if missing
 // Returns contact for ID, or null if absent
 // Fetches contact by ID; null if not found
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    //Update information
    public boolean updateFirstName(String contactId, String newFirst) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setFirstName(newFirst);
        return true;
    }

    public boolean updateLastName(String contactId, String newLast) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setLastName(newLast);
        return true;
    }

    public boolean updateNumber(String contactId, String newNumber) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setNumber(newNumber);
        return true;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setAddress(newAddress);
        return true;
    }
}
