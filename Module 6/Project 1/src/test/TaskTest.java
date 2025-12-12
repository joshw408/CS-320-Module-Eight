//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025

package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import source.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    @DisplayName("Valid task is created when fields meet constraints")
    void validTaskCreated() {
        Task task = new Task("Clean Kitchen", "Clean Entire Kitchen");
        assertNotNull(task.getTaskID());
        assertTrue(task.getTaskID().length() <= 10);
        assertEquals("Clean Kitchen", task.getName());
        assertEquals("Clean Entire Kitchen", task.getDescription());
    }

    @Test
    @DisplayName("Task ID is generated, not null, and <= 10 characters")
    void taskId_generatedAndConstrained() {
        Task task = new Task("Name", "Description");
        assertNotNull(task.getTaskID());
        assertTrue(task.getTaskID().length() <= 10);
    }

    @Test
    @DisplayName("Name cannot be null")
    void name_null_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task(null, "Valid description"));
    }

    @Test
    @DisplayName("Name cannot exceed 20 characters")
    void name_tooLong_throwsException() {
        String longName = "This name is longer than twenty chars";
        assertThrows(IllegalArgumentException.class,
                () -> new Task(longName, "Valid description"));
    }

    @Test
    @DisplayName("Description cannot be null")
    void description_null_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("Valid name", null));
    }

    @Test
    @DisplayName("Description cannot exceed 50 characters")
    void description_tooLong_throwsException() {
        String longDesc =
                "This description is going to be very, very, very long"
              + " and exceed the fifty character limit.";
        assertThrows(IllegalArgumentException.class,
                () -> new Task("Valid name", longDesc));
    }

    @Test
    @DisplayName("Setters update fields when values are valid")
    void setters_updateFields_whenValid() {
        Task task = new Task("Old name", "Old description");
        task.setName("New name");
        task.setDescription("New description");

        assertEquals("New name", task.getName());
        assertEquals("New description", task.getDescription());
    }

    @Test
    @DisplayName("Setter for name enforces null and length constraints")
    void setName_enforcesConstraints() {
        Task task = new Task("Name", "Description");

        assertThrows(IllegalArgumentException.class,
                () -> task.setName(null));

        String longName = "This name is longer than twenty chars";
        assertThrows(IllegalArgumentException.class,
                () -> task.setName(longName));
    }

    @Test
    @DisplayName("Setter for description enforces null and length constraints")
    void setDescription_enforcesConstraints() {
        Task task = new Task("Name", "Description");

        assertThrows(IllegalArgumentException.class,
                () -> task.setDescription(null));

        String longDesc =
                "This description is going to be very, very, very long"
              + " and exceed the fifty character limit.";
        assertThrows(IllegalArgumentException.class,
                () -> task.setDescription(longDesc));
    }
}
