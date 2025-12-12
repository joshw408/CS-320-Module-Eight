package source;

import java.util.concurrent.atomic.AtomicLong;

public class Task {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    private final String taskID;
    private String name;
    private String description;

    public Task(String name, String description) {
        this.taskID = generateId();
        setName(name);
        setDescription(description);
    }

    private static String generateId() {
        long value = ID_GENERATOR.incrementAndGet();
        String id = Long.toString(value);

        if (id.length() > 10) {
            throw new IllegalStateException("Generated task ID exceeds 10 characters");
        }
        return id;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Task name must not be null");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("Task name must be <= 20 characters");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Task description must not be null");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Task description must be <= 50 characters");
        }
        this.description = description;
    }
}
