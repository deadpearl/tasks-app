package kz.pearl.tasks_service.service;


import kz.pearl.tasks_service.dto.TaskDTO;
import kz.pearl.tasks_service.dto.TaskRequestDTO;
import kz.pearl.tasks_service.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDTO saveTask(TaskRequestDTO taskRequestDTO);
    void deleteTask(Long id);
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getTasksByUserId(Long userId);
    Task updateTask(TaskDTO taskDTO);
    Iterable<Task> getAll();
    void markAsDone(Long id);
}
