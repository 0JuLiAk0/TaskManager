package com.julia.taskmanager.repository;

import com.julia.taskmanager.model.Task;
import com.julia.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    List<Task> findAllByUser(User user);
}
