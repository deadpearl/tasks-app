package kz.pearl.tasks_service.service.impl;

import kz.pearl.tasks_service.dto.TaskDTO;
import kz.pearl.tasks_service.dto.TaskRequestDTO;
import kz.pearl.tasks_service.entity.Task;
import kz.pearl.tasks_service.repository.TaskRepository;
import kz.pearl.tasks_service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    private Task findById(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            return taskOptional.get();
        } else {
            throw new IllegalArgumentException("Task with id " + id + " not found");
        }
    }

    @Override
    public TaskDTO saveTask(TaskRequestDTO taskRequestDTO) {
        Task task = Task.builder()
                .id(null)
                .date(LocalDate.now())
                .description(taskRequestDTO.getDescription())
                .done(false)
                .userId(taskRequestDTO.getUserId())
                .build();
        taskRepository.save(task);
        return task.toDTO();
    }

    @Override
    public void deleteTask(Long id) {
        Task task = findById(id);
        taskRepository.delete(task);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = findById(id);
        return task.toDTO();
    }

    @Override
    public List<TaskDTO> getTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        if (!tasks.isEmpty()) {
            return tasks.stream()
                    .map(Task::toDTO)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Tasks with user id " + userId + " not found");
        }
    }


    @Override
    public Task updateTask(TaskDTO taskDTO) {
        Task task = findById(taskDTO.getId());
        task.setDate(taskDTO.getDate());
        task.setDescription(taskDTO.getDescription());
        task.setDone(taskDTO.isDone());
        task.setUserId(taskDTO.getUserId());
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void markAsDone(Long id) {
        Task task = findById(id);
        task.setDone(true);
        taskRepository.save(task);
    }
}
