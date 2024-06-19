package kz.pearl.tasks_service.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TaskRequestDTO {
    private String description;
    private Long userId;
}

