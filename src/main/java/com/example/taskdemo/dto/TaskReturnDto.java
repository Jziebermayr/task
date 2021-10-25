package com.example.taskdemo.dto;

import com.example.taskdemo.model.Priority;
import com.example.taskdemo.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskReturnDto {

    @Id
    @NotNull
    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDate dueDate;

    private LocalDate resolvedAt;

    private String title;

    private String description;

    private Priority priority;

    private Status status;

}
