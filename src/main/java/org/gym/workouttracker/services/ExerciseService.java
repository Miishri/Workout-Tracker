package org.gym.workouttracker.services;

import org.gym.workouttracker.entities.Exercise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExerciseService {

    Exercise createExercise();
    List<Exercise> getExercises();
    Exercise getExerciseById(long id);
    Exercise updateExercise(long id, Exercise userExercise);
    ResponseEntity<Exercise> deleteExercise(long id);

}
