//Joshua Williamson
//CS-320
//Module 5-1
//November 28th, 2025

package source;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();

    public String addAppointment(Date appointmentDate, String description) {
        String id = generateUniqueId();
        Appointment appt = new Appointment(id, appointmentDate, description);
        appointments.put(id, appt);
        return id;
    }

    public boolean deleteAppointment(String appointmentID) {
        if (appointmentID == null) return false;
        return appointments.remove(appointmentID) != null;
    }

    public Appointment getAppointment(String appointmentID) {
        if (appointmentID == null) return null;
        return appointments.get(appointmentID);
    }

    private String generateUniqueId() {
        String id;
        do {
            id = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        } while (appointments.containsKey(id));
        return id;
    }
}
