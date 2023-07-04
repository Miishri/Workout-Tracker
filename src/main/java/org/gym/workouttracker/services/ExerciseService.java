package org.gym.workouttracker.services;

import org.gym.workouttracker.models.ExerciseDTO;

import java.util.List;
import java.util.UUID;

public interface ExerciseService {

    ExerciseDTO createExercise(ExerciseDTO exerciseDTO);
    List<ExerciseDTO> getExercises(String exerciseName);
    ExerciseDTO getExerciseById(UUID id);
    ExerciseDTO updateExercise(UUID id, ExerciseDTO userExercise);
    ExerciseDTO deleteExerciseById(UUID id);

}
