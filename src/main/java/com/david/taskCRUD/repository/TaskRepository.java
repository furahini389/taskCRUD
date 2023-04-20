package com.david.taskCRUD.repository;

import com.david.taskCRUD.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    //All CRUD methods for databases
}
