
//Joshua Williamson
//CS-320
//Module 4-1
//November 19th, 2025


package source;

import java.util.concurrent.atomic.AtomicLong;

public class Task {

    private static final AtomicLong idGenerator = new AtomicLong();

    private final String taskID;
    private String name;
    private String description;

    // CONSTRUCTOR
    /*
     * Creates a new Task with an auto-generated ID.
     * Name is max 20 chars, description is max 50 chars.
     * None of the fields will ever be null after construction.
     */
    public Task(String name, String description) {
        this.taskID = generateId();
        setNameInternal(name);
        setDescriptionInternal(description);
    }

    //ID generator
    private String generateId() {
        long value = idGenerator.incrementAndGet();
        String raw = Long.toString(value);

        // Requirement: cannot be longer than 10 characters
        if (raw.length() > 10) {
            return raw.substring(0, 10);
        }
        return raw;
    }

    //Getters
    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setters for updatable fields

    // Public setters for TaskService updates
    public void setName(String name) {
        setNameInternal(name);
    }

    public void setDescription(String description) {
        setDescriptionInternal(description);
    }

    // Internal helpers enforce constraints and not-null
    private void setNameInternal(String name) {
        // Requirement: name shall not be null & max 20 characters
        if (name == null || name.isBlank()) {
            this.name = "NULL";
        } else if (name.length() > 20) {
            this.name = name.substring(0, 20);
        } else {
            this.name = name;
        }
    }

    private void setDescriptionInternal(String description) {
        // Requirement: description shall not be null & max 50 characters
        if (description == null || description.isBlank()) {
            this.description = "NULL";
        } else if (description.length() > 50) {
            this.description = description.substring(0, 50);
        } else {
            this.description = description;
        }
    }
}
