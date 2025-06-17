package taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("001", "Test Task", "This is a test task.");
        assertEquals("001", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task.", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Desc");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Desc");
        });
    }

    @Test
    public void testSetNameValidation() {
        Task task = new Task("001", "Valid", "Valid");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This name is way too long to be valid");
        });
    }

    @Test
    public void testSetDescriptionValidation() {
        Task task = new Task("001", "Valid", "Valid");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long to be accepted by the task object. It exceeds fifty characters.");
        });
    }
}
