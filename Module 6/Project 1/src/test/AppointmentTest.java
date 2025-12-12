//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025

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
    @DisplayName("Valid appointment has been created")
    void validAppointment() {
        Appointment a = new Appointment("ABC123", futureDate(), "Testing description");
        assertEquals("ABC123", a.getAppointmentID());
    }

    @Test
    @DisplayName("Appointment ID must be <= 10 characters long")
    void invalidIdLength() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("THISIDISTOOLONG", futureDate(), "Test"));
    }

    @Test
    @DisplayName("Appointment ID cannot be a null")
    void nullId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(null, futureDate(), "Test"));
    }

    @Test
    @DisplayName("Appointment date cannot be a null")
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
    @DisplayName("Description cannot be a null")
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

    @Test
    @DisplayName("setAppointmentDate enforces not null and not in the past")
    void setAppointmentDate_enforcesConstraints() {
        Appointment a = new Appointment("ID1", futureDate(), "Test");

        assertThrows(IllegalArgumentException.class,
                () -> a.setAppointmentDate(null));

        assertThrows(IllegalArgumentException.class,
                () -> a.setAppointmentDate(new Date(0)));

        Date newFuture = new Date(System.currentTimeMillis() + 120_000);
        a.setAppointmentDate(newFuture);
        assertEquals(newFuture, a.getAppointmentDate());
    }

    @Test
    @DisplayName("setDescription enforces null and length constraints")
    void setDescription_enforcesConstraints() {
        Appointment a = new Appointment("ID1", futureDate(), "Test");

        assertThrows(IllegalArgumentException.class,
                () -> a.setDescription(null));

        String longDesc = "A".repeat(51);
        assertThrows(IllegalArgumentException.class,
                () -> a.setDescription(longDesc));

        a.setDescription("New description");
        assertEquals("New description", a.getDescription());
    }
}
