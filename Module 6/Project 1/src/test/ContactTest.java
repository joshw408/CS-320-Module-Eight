//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025

package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import source.Contact;

public class ContactTest {

    //ID
    @Test
    @DisplayName("Contact ID is generated, non-null, and 10 chars")
    void idGeneratedAndLengthTen() {
        Contact c = new Contact("John","Doe","1234567890","123 Apple Blvd");
        assertNotNull(c.getContactID());
        assertEquals(10, c.getContactID().length());
    }

    //Firstname
    @Test
    @DisplayName("firstName: null -> IllegalArgumentException")
    void firstNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null,"Doe","1234567890","123 Apple Blvd"));
    }

    @Test
    @DisplayName("firstName: >10 chars -> IllegalArgumentException")
    void firstNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ABCDEFGHIJK","Doe","1234567890","123 Apple Blvd"));
    }

    //Lastname
    @Test
    @DisplayName("lastName: null -> IllegalArgumentException")
    void lastNameNullThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John",null,"1234567890","123 Apple Blvd"));
    }

    @Test
    @DisplayName("lastName: >10 chars -> IllegalArgumentException")
    void lastNameTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","ABCDEFGHIJK","1234567890","123 Apple Blvd"));
    }

    //PhoneNumber
    @Test
    @DisplayName("phone: must be exactly 10 digits")
    void phoneMustBeExactly10Digits() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","Doe","123456789","123 Apple Blvd"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","Doe","12345678901","123 Apple Blvd"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","Doe","12345abcde","123 Apple Blvd"));
    }

    @Test
    @DisplayName("phone: null -> IllegalArgumentException")
    void phoneNullThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","Doe",null,"123 Apple Blvd"));
    }

    //Address
    @Test
    @DisplayName("address: null -> IllegalArgumentException")
    void addressNullThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","Doe","1234567890",null));
    }

    @Test
    @DisplayName("address: >30 chars -> IllegalArgumentException")
    void addressTooLongThrows() {
        String longAddr = "1234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("John","Doe","1234567890", longAddr));
    }
}
