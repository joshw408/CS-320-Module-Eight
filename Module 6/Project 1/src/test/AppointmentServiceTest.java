//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025

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
    @DisplayName("Adding an appointment stores it and then returns unique ID")
    void addAppointment() {
        AppointmentService svc = new AppointmentService();
        String id = svc.addAppointment(futureDate(), "Dentist visit");

        assertNotNull(id);
        assertEquals(10, id.length());
        assertNotNull(svc.getAppointment(id));
    }

    @Test
    @DisplayName("Delete appointment returns true when it is successful")
    void deleteExistingAppointment() {
        AppointmentService svc = new AppointmentService();
        String id = svc.addAppointment(futureDate(), "Checkup");

        assertTrue(svc.deleteAppointment(id));
        assertNull(svc.getAppointment(id));
    }

    @Test
    @DisplayName("Delete returns false for a non-existing ID")
    void deleteMissingAppointment() {
        AppointmentService svc = new AppointmentService();
        assertFalse(svc.deleteAppointment("UNKNOWN"));
    }

    @Test
    @DisplayName("Service handles null appointment ID for delete and get")
    void nullIdHandling() {
        AppointmentService svc = new AppointmentService();
        assertFalse(svc.deleteAppointment(null));
        assertNull(svc.getAppointment(null));
    }
}
