//Joshua Williamson
//CS-320
//Module 6-1
//December 5th, 2025

package source;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

 // Adds a task and returns its new ID
 // Create task and return generated ID
 // Adds task; returns unique ID
    public String addTask(String name, String description) {
        Task task = new Task(name, description);
        String id = task.getTaskID();

     // AtomicLong ensures uniqueness, but we still enforce
     // Unique via AtomicLong, with extra enforcement
     // AtomicLong makes IDs unique, but double-check anyway
        while (tasks.containsKey(id)) {
            task = new Task(name, description);
            id = task.getTaskID();
        }

        tasks.put(id, task);
        return id;
    }

 // Deletes task by ID; true if removed
 // Remove task by ID; returns true if found
 // Delete by ID; true on success, false if missing
    public boolean deleteTask(String taskID) {
        return tasks.remove(taskID) != null;
    }

 // Updates name by ID; true if found
 // Update task name by ID; returns true if it exists
 // Changes name by ID; true if task present
    public boolean updateTaskName(String taskID, String newName) {
        Task task = tasks.get(taskID);
        if (task == null) {
            return false;
        }
        task.setName(newName);
        return true;
    }

 // Updates description by ID; true if found
 // Update task description; true if the ID exists
 // Changes description by ID; returns true if present
    public boolean updateTaskDescription(String taskID, String newDescription) {
        Task task = tasks.get(taskID);
        if (task == null) {
            return false;
        }
        task.setDescription(newDescription);
        return true;
    }

    // Optional helper for tests / debugging
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
