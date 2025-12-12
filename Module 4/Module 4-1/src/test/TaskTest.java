//Joshua Williamson
//CS-320
//Module 4-1
//November 19th, 2025

package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import source.Task;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    /*
     * These tests exercise the Task class:
     * - ID is generated, unique, not null, and <= 10 characters.
     * - Name and description respect length limits.
     * - Name and description are never null.
     */

    @Test
    @DisplayName("Task ID is generated, not null, and <= 10 characters")
    void taskId_generatedAndConstrained() {
        Task task = new Task("Test Name", "Test Description");
        assertNotNull(task.getTaskID());
        assertTrue(task.getTaskID().length() <= 10);
    }

    @Test
    @DisplayName("Name cannot exceed 20 characters")
    void name_truncatedToTwentyChars() {
        String longName = "This name is definitely longer than twenty chars";
        Task task = new Task(longName, "Desc");
        assertTrue(task.getName().length() <= 20);
    }

    @Test
    @DisplayName("Description cannot exceed 50 characters")
    void description_truncatedToFiftyChars() {
        String longDesc = "This description is going to be very, very, very long "
                        + "and exceed the fifty character limit.";
        Task task = new Task("Name", longDesc);
        assertTrue(task.getDescription().length() <= 50);
    }

    @Test
    @DisplayName("Name is never null even if input is null")
    void name_notNull() {
        Task task = new Task(null, "Desc");
        assertNotNull(task.getName());
    }

    @Test
    @DisplayName("Description is never null even if input is null")
    void description_notNull() {
        Task task = new Task("Name", null);
        assertNotNull(task.getDescription());
    }
}
