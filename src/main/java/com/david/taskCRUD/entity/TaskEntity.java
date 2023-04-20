package com.david.taskCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task_Info")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "goal")
    String goal;
    @Column(name = "time")
    String time;
    @Column(name = "complexity")
    String complexity;
    @Column(name = "resources")
    String resources;
    @Column(name = "dependence")
    String dependence;
    @Column(name = "measurable")
    String measurable;
    @Column(name = "assignable")
    String assignable;
}
