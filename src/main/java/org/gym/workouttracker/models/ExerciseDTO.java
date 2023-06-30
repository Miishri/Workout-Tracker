package org.gym.workouttracker.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ExerciseDTO {
    private UUID id;
    private String exerciseName;
    private String exerciseDetails;
    private Integer recentExerciseSets;
    private LocalDateTime exerciseCreationDate;
}
