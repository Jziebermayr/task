package com.example.taskdemo.model;

import com.example.taskdemo.dto.TaskCreationDto;
import com.example.taskdemo.dto.TaskUpdateDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMappingTest {
    private static final ModelMapper modelMapper = new ModelMapper();


    @Test
    public void checkCreationDtoToTaskMapping() {
        TaskCreationDto taskCreationDto = new TaskCreationDto();
        taskCreationDto.setTitle("Testing title");
        taskCreationDto.setDescription("Testing description");
        taskCreationDto.setDueDate(LocalDate.of(2021,10,28));

        Task exam = modelMapper.map(taskCreationDto, Task.class);
        assertEquals(taskCreationDto.getTitle(), exam.getTitle());
        assertEquals(taskCreationDto.getDescription(), exam.getDescription());
        assertEquals(taskCreationDto.getCreatedAt(), exam.getCreatedAt());
        assertEquals(taskCreationDto.getUpdatedAt(), exam.getUpdatedAt());
        assertEquals(taskCreationDto.getDueDate(), exam.getDueDate());
    }

    @Test
    public void checkUpdateDtoToTaskMapping() {
        TaskUpdateDto taskUpdateDto = new TaskUpdateDto();
        taskUpdateDto.setId(1L);
        taskUpdateDto.setTitle("Updating title");
        taskUpdateDto.setDescription("Updating description");
        taskUpdateDto.setDueDate(LocalDate.of(2021,10,28));
        taskUpdateDto.setStatus(Status.RESOLVED);

        Task exam = modelMapper.map(taskUpdateDto, Task.class);
        assertEquals(taskUpdateDto.getId(), exam.getId());
        assertEquals(taskUpdateDto.getTitle(), exam.getTitle());
        assertEquals(taskUpdateDto.getDescription(), exam.getDescription());
        assertEquals(taskUpdateDto.getUpdatedAt(), exam.getUpdatedAt());
        assertEquals(taskUpdateDto.getDueDate(), exam.getDueDate());
        assertEquals(taskUpdateDto.getStatus(), exam.getStatus());
    }
}
