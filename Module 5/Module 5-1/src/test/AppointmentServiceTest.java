//Joshua Williamson
//CS-320
//Module 5-1
//November 28th, 2025

package test;

import source.Appointment;
import source.AppointmentService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 60_000);
    }

    @Test
    @DisplayName("Adding an appointment stores it and returns unique ID")
    void addAppointment() {
        AppointmentService svc = new AppointmentService();
        String id = svc.addAppointment(futureDate(), "Dentist visit");

        assertNotNull(id);
        assertEquals(10, id.length());
        assertNotNull(svc.getAppointment(id));
    }

    @Test
    @DisplayName("Delete appointment returns true when successful")
    void deleteExistingAppointment() {
        AppointmentService svc = new AppointmentService();
        String id = svc.addAppointment(futureDate(), "Checkup");

        assertTrue(svc.deleteAppointment(id));
        assertNull(svc.getAppointment(id));
    }

    @Test
    @DisplayName("Delete returns false for non-existing ID")
    void deleteMissingAppointment() {
        AppointmentService svc = new AppointmentService();
        assertFalse(svc.deleteAppointment("UNKNOWN"));
    }
}
