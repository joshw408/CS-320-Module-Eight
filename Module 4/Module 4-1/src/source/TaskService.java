//Joshua Williamson
//CS-320
//Module 4-1
//November 19th, 2025


package source;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    // Add a new task, returns the generated unique ID
    public String addTask(String name, String description) {
        Task task = new Task(name, description);
        String id = task.getTaskID();

        // Should be unique
        while (tasks.containsKey(id)) {
            task = new Task(name, description);
            id = task.getTaskID();
        }

        tasks.put(id, task);
        return id;
    }

    // Delete task by ID, return true if removed, false if not found
    public boolean deleteTask(String taskID) {
        return tasks.remove(taskID) != null;
    }

    // Update name by ID, return true if task exists, false otherwise
    public boolean updateTaskName(String taskID, String newName) {
        Task task = tasks.get(taskID);
        if (task == null) {
            return false;
        }
        task.setName(newName);
        return true;
    }

    // Update description by ID, return true if task exists, false otherwise
    public boolean updateTaskDescription(String taskID, String newDescription) {
        Task task = tasks.get(taskID);
        if (task == null) {
            return false;
        }
        task.setDescription(newDescription);
        return true;
    }

    // Optional helper for debugging
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
