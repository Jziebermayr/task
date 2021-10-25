package com.example.taskdemo;

import com.example.taskdemo.controller.TaskController;
import com.example.taskdemo.dto.TaskCreationDto;
import com.example.taskdemo.dto.TaskReturnDto;
import com.example.taskdemo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class TaskDemoApplication {

        public static void main(String[] args) {
        SpringApplication.run(TaskDemoApplication.class, args);
    }

}
