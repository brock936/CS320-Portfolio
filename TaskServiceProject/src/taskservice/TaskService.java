package taskservice;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        taskMap.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        taskMap.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        task.setName(newName);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = taskMap.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        task.setDescription(newDescription);
    }

    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }
}
