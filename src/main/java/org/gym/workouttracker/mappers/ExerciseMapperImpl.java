package org.gym.workouttracker.mappers;

import org.gym.workouttracker.entities.Exercise;
import org.gym.workouttracker.models.ExerciseDTO;

public class ExerciseMapperImpl implements ExerciseMapper {
    @Override
    public Exercise ExerciseDtoToExercise(ExerciseDTO exerciseDTO) {
        return Exercise.builder()
                .id(exerciseDTO.getId())
                .exerciseName(exerciseDTO.getExerciseName())
                .exerciseDetails(exerciseDTO.getExerciseDetails())
                .recentExerciseSets(exerciseDTO.getRecentExerciseSets())
                .exerciseCreationDate(exerciseDTO.getExerciseCreationDate())
                .build();
    }

    @Override
    public ExerciseDTO ExerciseToExerciseDto(Exercise exercise) {
        return ExerciseDTO.builder()
                .id(exercise.getId())
                .exerciseName(exercise.getExerciseName())
                .exerciseDetails(exercise.getExerciseDetails())
                .recentExerciseSets(exercise.getRecentExerciseSets())
                .exerciseCreationDate(exercise.getExerciseCreationDate()).build();
    }
}
