package com.julia.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="Title",nullable=false)
    private String title;

    @Column(name="Description", length=300, unique=false)
    private String description;

    @Column(name="Status_completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
