package kz.pearl.tasks_service.entity;

import kz.pearl.tasks_service.dto.TaskDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String description;
    private boolean done;
    private Long userId;
    public TaskDTO toDTO() {
        return TaskDTO.builder()
                .id(this.id)
                .date(this.date)
                .description(this.description)
                .done(this.done)
                .userId(this.userId)
                .build();
    }
}
