package com.david.taskCRUD.controller;

import com.david.taskCRUD.entity.TaskEntity;
import com.david.taskCRUD.exception.TaskException;
import com.david.taskCRUD.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task_Info")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //code for getting all task
    @GetMapping
    public List<TaskEntity> getAllTask(TaskEntity taskEntity){
        return taskRepository.findAll();
    }

    //code for adding/create task
    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity taskEntity){
        return taskRepository.save(taskEntity);
    }

    //Code for reading or getting task
    @GetMapping("{}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable long id){
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(()->new TaskException("Task not found"));
        return ResponseEntity.ok(taskEntity);
    }

    //Code for updating task
    @PutMapping("{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable long id,@RequestBody TaskEntity taskEntityDetails){
        TaskEntity updateTask = taskRepository.findById(id)
                .orElseThrow(()->new TaskException("Task not found"));

        updateTask.setMeasurable(taskEntityDetails.getMeasurable());
        updateTask.setTime(taskEntityDetails.getTime());
        updateTask.setResources(taskEntityDetails.getResources());
        updateTask.setGoal(taskEntityDetails.getGoal());
        updateTask.setComplexity(taskEntityDetails.getComplexity());
        updateTask.setDependence(taskEntityDetails.getDependence());
        updateTask.setAssignable(taskEntityDetails.getAssignable());

        taskRepository.save(updateTask);
        return ResponseEntity.ok(updateTask);
    }

    //Code for deleting task
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable long id){
        TaskEntity deleteTask = taskRepository.findById(id)
                .orElseThrow(()->new TaskException("Task Not found"));

        taskRepository.delete(deleteTask);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
