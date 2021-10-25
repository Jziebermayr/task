package com.example.taskdemo.dto;

import com.example.taskdemo.model.Priority;
import com.example.taskdemo.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskCreationDto {

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime updatedAt = LocalDateTime.now();

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private Priority priority;

    @JsonIgnore
    private Status status = Status.OPEN;
}
