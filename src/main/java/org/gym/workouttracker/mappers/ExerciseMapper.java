package org.gym.workouttracker.mappers;

import org.gym.workouttracker.entities.Exercise;
import org.gym.workouttracker.models.ExerciseDTO;

public interface ExerciseMapper {
    Exercise ExerciseDtoToExercise(ExerciseDTO exerciseDTO);
    ExerciseDTO ExerciseToExerciseDto(Exercise exercise);
}
