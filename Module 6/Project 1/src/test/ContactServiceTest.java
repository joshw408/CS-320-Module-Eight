//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025


package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import source.Contact;
import source.ContactService;

public class ContactServiceTest {

    @Test
    @DisplayName("Service can add a contact and return a unique 10-char ID")
    void addContact_returnsId_andStores() {
        ContactService svc = new ContactService();
        String id = svc.addContact("Bob","Jones","4445556666","123 Apple Blvd");

        assertNotNull(id);
        assertEquals(10, id.length());

        Contact c = svc.getContact(id);
        assertNotNull(c);
        assertEquals("Bob", c.getFirstName());
        assertEquals("Jones", c.getLastName());
        assertEquals("4445556666", c.getNumber());
        assertEquals("123 Apple Blvd", c.getAddress());
    }

    @Test
    @DisplayName("Delete by ID removes and returns true. Missing will return false")
    void deleteContact_behavesAsExpected() {
        ContactService svc = new ContactService();
        String id = svc.addContact("A","B","4445556666","Addr");
        assertTrue(svc.deleteContact(id));
        assertFalse(svc.deleteContact(id));
        assertNull(svc.getContact(id));
    }

    @Test
    @DisplayName("Update fields by ID")
    void updateFieldsById() {
        ContactService svc = new ContactService();
        String id = svc.addContact("Bob","Jones","4445556666","123 Apple Blvd");

        assertTrue(svc.updateFirstName(id, "Rob"));
        assertTrue(svc.updateLastName(id,  "Stone"));
        assertTrue(svc.updateNumber(id,    "1112223333"));
        assertTrue(svc.updateAddress(id,   "987 Orange Ave"));

        Contact c = svc.getContact(id);
        assertEquals("Rob", c.getFirstName());
        assertEquals("Stone", c.getLastName());
        assertEquals("1112223333", c.getNumber());
        assertEquals("987 Orange Ave", c.getAddress());
    }

    @Test
    @DisplayName("Update on missing ID returns false")
    void updateMissingIdReturnsFalse() {
        ContactService svc = new ContactService();
        assertFalse(svc.updateFirstName("does-not-exist", "X"));
        assertFalse(svc.updateLastName("does-not-exist", "Y"));
        assertFalse(svc.updateNumber("does-not-exist",   "1234567890"));
        assertFalse(svc.updateAddress("does-not-exist",  "Z"));
    }
}
