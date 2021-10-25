package com.example.taskdemo.service;

import com.example.taskdemo.dto.TaskCreationDto;
import com.example.taskdemo.dto.TaskReturnDto;
import com.example.taskdemo.model.Task;
import com.example.taskdemo.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void whenCreateTask_shouldReturnTask() {
        Task task = new Task();
        task.setTitle("Test task");
        task.setDueDate(LocalDate.of(2021,10,28));

        when(taskRepository.save(ArgumentMatchers.any(Task.class))).thenReturn(task);
        TaskCreationDto creationDto = modelMapper.map(task, TaskCreationDto.class);
        TaskReturnDto returned = taskService.createTask(creationDto);
        Assert.assertEquals(returned.getTitle(), creationDto.getTitle());
        verify(taskRepository).save(modelMapper.map(creationDto, Task.class));
    }


}
