package com.example.taskdemo.service;

import com.example.taskdemo.dto.TaskCreationDto;
import com.example.taskdemo.dto.TaskReturnDto;
import com.example.taskdemo.dto.TaskUpdateDto;
import com.example.taskdemo.exception.ResourceNotFoundException;
import com.example.taskdemo.model.Priority;
import com.example.taskdemo.model.Status;
import com.example.taskdemo.model.Task;
import com.example.taskdemo.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskReturnDto> getAllTasks() {
        List<Task> all = taskRepository.findAll();
        List<TaskReturnDto> returnDtos = all.stream().
                map(task -> modelMapper.map(task, TaskReturnDto.class)).
                sorted(Comparator.comparing(TaskReturnDto::getCreatedAt)).
                collect(Collectors.toList());
        return returnDtos;
    }

    public TaskReturnDto getTask(Long taskID) {
        return modelMapper.map(getTaskModel(taskID), TaskReturnDto.class);
    }

    public TaskReturnDto createTask(TaskCreationDto taskDto) {
        Task createdTask = modelMapper.map(taskDto, Task.class);
        if(createdTask.getPriority() == null){
            createdTask.setPriority(Priority.MEDIUM);
        }
        return modelMapper.map(taskRepository.save(createdTask), TaskReturnDto.class);
    }

    public TaskReturnDto updateTask(TaskUpdateDto taskDto) {
        Task persistedTask = getTaskModel(taskDto.getId());
        Task updateTask = modelMapper.map(taskDto, Task.class);
        if(taskDto.getStatus().equals(Status.RESOLVED) && persistedTask.getStatus().equals(Status.OPEN)){
            updateTask.setResolvedAt(LocalDate.now());
        }
        updateTask.setCreatedAt(persistedTask.getCreatedAt());
        return modelMapper.map(taskRepository.save(updateTask), TaskReturnDto.class);
    }

    public void deleteTask(Long taskID) {
        Task foundTask = getTaskModel(taskID);
        taskRepository.delete(foundTask);
    }

    private Task getTaskModel(Long taskID) {
        return taskRepository.findById(taskID).orElseThrow(
                () -> new ResourceNotFoundException("Task not found " + taskID));
    }
}
