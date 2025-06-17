package taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;
    private Task task;

    @BeforeEach
    public void setup() {
        service = new TaskService();
        task = new Task("001", "Initial", "Initial description");
        service.addTask(task);
    }

    @Test
    public void testAddTaskSuccess() {
        Task newTask = new Task("002", "New", "New description");
        service.addTask(newTask);
        assertEquals("New", service.getTask("002").getName());
    }

    @Test
    public void testAddDuplicateTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("001", "Another", "Duplicate"));
        });
    }

    @Test
    public void testDeleteTaskSuccess() {
        service.deleteTask("001");
        assertNull(service.getTask("001"));
    }

    @Test
    public void testDeleteNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("999");
        });
    }

    @Test
    public void testUpdateTaskName() {
        service.updateTaskName("001", "Updated Name");
        assertEquals("Updated Name", service.getTask("001").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        service.updateTaskDescription("001", "Updated Description");
        assertEquals("Updated Description", service.getTask("001").getDescription());
    }

    @Test
    public void testUpdateNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("999", "Name");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("999", "Description");
        });
    }
}
