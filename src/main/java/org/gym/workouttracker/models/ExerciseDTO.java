package org.gym.workouttracker.models;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ExerciseDTO {
    private UUID id;
    @NotBlank(message = "Exercise name is required")
    private String exerciseName;
    @Size(max = 150)
    private String exerciseDetails;
    @Max(20)
    private Integer recentExerciseSets;
    private LocalDateTime exerciseCreationDate;
}
