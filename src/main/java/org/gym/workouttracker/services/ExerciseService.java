package org.gym.workouttracker.services;

import org.gym.workouttracker.models.ExerciseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {

    ExerciseDTO createExercise(ExerciseDTO exerciseDTO);
    List<ExerciseDTO> getExercises(String exerciseName);
    Optional<ExerciseDTO> getExerciseById(UUID id);
    Optional<ExerciseDTO> updateExercise(UUID id, ExerciseDTO userExercise);
    Optional<ExerciseDTO> deleteExercise(UUID id);

}
