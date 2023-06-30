package org.gym.workouttracker.repositories;

import org.gym.workouttracker.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
    List<Exercise> findExercisesByExerciseNameIgnoreCase(String exerciseName);
}
