package com.david.taskCRUD;

import com.david.taskCRUD.entity.TaskEntity;
import com.david.taskCRUD.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskCrudApplication.class, args);
	}

	@Autowired
	private TaskRepository taskRepository;
	@Override
	public void run(String... args) throws Exception {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setAssignable("ghds");
		taskEntity.setComplexity("hdgs");
		taskEntity.setDependence("hdhg");
		taskEntity.setGoal("hjdg");
		taskEntity.setResources("hdy");
		taskEntity.setTime("hdsg");
		taskEntity.setMeasurable("gsam");
		taskRepository.save(taskEntity);
	}
}
