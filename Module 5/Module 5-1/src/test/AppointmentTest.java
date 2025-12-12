//Joshua Williamson
//CS-320
//Module 5-1
//November 28th, 2025

package test;

import source.Appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 60_000);
    }

    @Test
    @DisplayName("Valid appointment is created")
    void validAppointment() {
        Appointment a = new Appointment("ABC123", futureDate(), "Testing description");
        assertEquals("ABC123", a.getAppointmentID());
    }

    @Test
    @DisplayName("Appointment ID must be <= 10 characters")
    void invalidIdLength() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("THISIDISTOOLONG", futureDate(), "Test"));
    }

    @Test
    @DisplayName("Appointment ID cannot be null")
    void nullId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(null, futureDate(), "Test"));
    }

    @Test
    @DisplayName("Appointment date cannot be null")
    void nullDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("ID1", null, "Test"));
    }

    @Test
    @DisplayName("Appointment date cannot be in the past")
    void pastDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("ID1", new Date(0), "Test"));
    }

    @Test
    @DisplayName("Description cannot be null")
    void nullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("ID1", futureDate(), null));
    }

    @Test
    @DisplayName("Description cannot exceed 50 characters")
    void descriptionTooLong() {
        String longDesc = "A".repeat(51);
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("ID1", futureDate(), longDesc));
    }
}
