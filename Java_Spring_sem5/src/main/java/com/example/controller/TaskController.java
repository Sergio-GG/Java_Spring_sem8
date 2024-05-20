package com.example.controller;

import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.service.TaskService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping
    public Task createTask(@RequestBody ObjectNode node){
        Task task = new Task();
        String description = node.get("description").asText();
        String taskStatus = node.get("taskStatus").asText();
        task.setDescription(description);
        task.setTaskStatus(TaskStatus.taskStatusForValue(taskStatus));
        return taskService.createTask(task);
    }
    @GetMapping("/{status}")
    public List<Task> getTasksByStatus(TaskStatus taskStatus){
        return taskService.getTasksByStatus(taskStatus);
    }
    @GetMapping("/update")
    public Task updateTaskStatus(Long id, TaskStatus taskStatus){
        return taskService.updateTaskById(id, taskStatus);
    }
    @GetMapping("/remove/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.removeTask(id);
    }
}
