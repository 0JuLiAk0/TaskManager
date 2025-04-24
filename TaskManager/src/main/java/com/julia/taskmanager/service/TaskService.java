package com.julia.taskmanager.service;

import com.julia.taskmanager.model.Task;
import com.julia.taskmanager.model.User;
import com.julia.taskmanager.repository.TaskRepository;
import com.julia.taskmanager.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Task> getAllTasks(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return taskRepository.findAllByUser(user);
    }

    public Task createTask(Task task, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id, String username) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (task.getUser().getUsername().equals(username)) {
            taskRepository.deleteById(id);
        } else{
            throw new RuntimeException("Access denied");
        }
    }

    public Task markAsCompleted(Long id, String username) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (task.getUser().getUsername().equals(username)) {
            task.setCompleted(true);
            return taskRepository.save(task);
        }else {
            throw new RuntimeException("Access denied");
        }
    }
}
