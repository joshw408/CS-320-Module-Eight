//Joshua Williamson
//CS-320
//Module 4-1
//November 19th, 2025


package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import source.Task;
import source.TaskService;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    @DisplayName("Service can add a task and return a unique ID")
    void addTask_returnsId_andStores() {
        TaskService svc = new TaskService();
        String id = svc.addTask("Homework", "Complete milestone");

        assertNotNull(id);
        assertTrue(id.length() <= 10);

        Task task = svc.getTask(id);
        assertNotNull(task);
        assertEquals("Homework", task.getName());
        assertEquals("Complete milestone", task.getDescription());
    }

    @Test
    @DisplayName("Delete by ID removes and returns true; missing returns false")
    void deleteTask_behavesAsExpected() {
        TaskService svc = new TaskService();
        String id = svc.addTask("Task1", "Desc1");

        assertTrue(svc.deleteTask(id));      // first delete succeeds
        assertFalse(svc.deleteTask(id));     // second delete fails (already gone)
    }

    @Test
    @DisplayName("Update methods change only the specified fields")
    void updateTask_updatesFields() {
        TaskService svc = new TaskService();
        String id = svc.addTask("Homework", "Complete milestone");

        assertTrue(svc.updateTaskName(id, "Quiz"));
        assertTrue(svc.updateTaskDescription(id, "Study chapters 1-3"));

        Task task = svc.getTask(id);
        assertEquals("Quiz", task.getName());
        assertEquals("Study chapters 1-3", task.getDescription());
    }

    @Test
    @DisplayName("Updating a non-existent task ID returns false")
    void updateTask_missingId_returnsFalse() {
        TaskService svc = new TaskService();
        assertFalse(svc.updateTaskName("BAD_ID", "Name"));
        assertFalse(svc.updateTaskDescription("BAD_ID", "Desc"));
    }
}
