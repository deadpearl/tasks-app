package kz.pearl.tasks_service.controller;

import kz.pearl.tasks_service.dto.TaskRequestDTO;
import kz.pearl.tasks_service.dto.TaskDTO;
import kz.pearl.tasks_service.entity.Task;
import kz.pearl.tasks_service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public TaskDTO create(@RequestBody TaskRequestDTO taskRequestDTO) {
        return taskService.saveTask(taskRequestDTO);
    }
    @PutMapping("/update")
    public Task update(@RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/get/{id}")
    public TaskDTO getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/byUser/{id}")
    public List<TaskDTO> getTasksByUserId(@PathVariable Long id) {
        return taskService.getTasksByUserId(id);
    }

    @GetMapping("/getAll")
    public Iterable<Task> getAll() {
        return taskService.getAll();
    }
    @PatchMapping("/mark/{id}")
    public void patchMethod(@PathVariable Long id){
        taskService.markAsDone(id);
    }

}
