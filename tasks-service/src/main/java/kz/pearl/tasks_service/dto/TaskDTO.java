package kz.pearl.tasks_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TaskDTO {
    private Long id;
    private LocalDate date;
    private String description;
    private boolean done;
    private Long userId;
}
