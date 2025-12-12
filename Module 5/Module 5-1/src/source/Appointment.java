//Joshua Williamson
//CS-320
//Module 5-1
//November 28th, 2025


package source;

import java.util.Date;

public class Appointment {

    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and <= 10 characters.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null or in the past.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and <= 50 characters.");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null or in the past.");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and <= 50 characters.");
        }
        this.description = description;
    }
}
