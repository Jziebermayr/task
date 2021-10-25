package com.example.taskdemo.controller;

import com.example.taskdemo.dto.TaskCreationDto;
import com.example.taskdemo.dto.TaskReturnDto;
import com.example.taskdemo.dto.TaskUpdateDto;
import com.example.taskdemo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskReturnDto>> fetchAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<TaskReturnDto> fetchSingleTask(@PathVariable(value = "id") Long taskID) {
        return ResponseEntity.ok().body(taskService.getTask(taskID));
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskReturnDto> createTask(@RequestBody TaskCreationDto task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("tasks")
    public ResponseEntity<TaskReturnDto> updateTask(@RequestBody TaskUpdateDto taskUpdateDto) {
        TaskReturnDto task = taskService.updateTask(taskUpdateDto);
        return ResponseEntity.ok(task);

    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Long taskID) {
        taskService.deleteTask(taskID);
        return ResponseEntity.ok().build();
    }
}
