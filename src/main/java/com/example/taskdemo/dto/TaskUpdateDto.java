package com.example.taskdemo.dto;

import com.example.taskdemo.model.Priority;
import com.example.taskdemo.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskUpdateDto {

    @Id
    @NotNull
    private Long id;

    @JsonIgnore
    private final LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDate dueDate;

    private String title;

    private String description;

    private Priority priority;

    private Status status;
}
