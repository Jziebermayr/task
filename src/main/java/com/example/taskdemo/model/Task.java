package com.example.taskdemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "due_date")
    @NotNull
    private LocalDate dueDate;

    @Column(name = "resolved_at")
    private LocalDate resolvedAt;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private Status status;

}
