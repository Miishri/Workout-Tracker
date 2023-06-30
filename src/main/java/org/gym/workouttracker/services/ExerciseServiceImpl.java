package org.gym.workouttracker.services;

import lombok.extern.slf4j.Slf4j;
import org.gym.workouttracker.entities.Exercise;
import org.gym.workouttracker.exceptions.ExerciseNotFoundException;
import org.gym.workouttracker.mappers.ExerciseMapper;
import org.gym.workouttracker.models.ExerciseDTO;
import org.gym.workouttracker.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
    }
    @Override
    public ExerciseDTO createExercise(ExerciseDTO exerciseDTO) {
        log.debug("SERVICE--Create new exercise from DTO--SERVICE");

        return exerciseMapper
                .ExerciseToExerciseDto(exerciseRepository
                        .save(exerciseMapper.ExerciseDtoToExercise(exerciseDTO)));
    }

    @Override
    public List<ExerciseDTO> getExercises(String exerciseName) {

        if (StringUtils.hasText(exerciseName)) {
            log.debug("SERVICE--Get exercise list by String--SERVICE");
            return getAllExercisesByName(exerciseName);
        }

        log.debug("SERVICE--Get exercise list--SERVICE");
        return getAllExercises();
    }
    private List<ExerciseDTO> getAllExercises() {
        return exerciseMapper
                .ExerciseListToExerciseDtoList(exerciseRepository
                        .findAll());

    }
    private List<ExerciseDTO> getAllExercisesByName(String exerciseName){
        return exerciseMapper
                .ExerciseListToExerciseDtoList(exerciseRepository
                        .findExercisesByExerciseNameIgnoreCase(exerciseName));
    }

    @Override
    public Optional<ExerciseDTO> getExerciseById(UUID id) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
        if (exerciseOptional.isEmpty()) {
            throw new ExerciseNotFoundException();
        }
        log.debug("SERVICE--Get exercise by id--SERVICE");
        return Optional.of(exerciseMapper.ExerciseToExerciseDto(exerciseOptional.get()));
    }

    @Override
    public Optional<ExerciseDTO> updateExercise(UUID id, ExerciseDTO userExercise) {

        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);

        if (exerciseOptional.isPresent()) {
            Exercise exercise = updateExerciseVariables(exerciseOptional.get());
            exerciseRepository.save(exercise);
            return Optional.of(exerciseMapper.ExerciseToExerciseDto(exercise));
        }

        return Optional.empty();
    }
    private Exercise updateExerciseVariables(Exercise exercise) {
        return Exercise.builder()
                .id(exercise.getId())
                .exerciseName(exercise.getExerciseName())
                .exerciseDetails(exercise.getExerciseDetails())
                .recentExerciseSets(exercise.getRecentExerciseSets())
                .exerciseCreationDate(exercise.getExerciseCreationDate()).build();
    }

    @Override
    public Optional<ExerciseDTO> deleteExercise(UUID id) {
        if (exerciseRepository.findById(id).isPresent()) {
            Exercise deletedExercise = exerciseRepository.findById(id).get();
            exerciseRepository.deleteById(id);
            log.debug("--Delete exercise by id--");
            return Optional.of(exerciseMapper.ExerciseToExerciseDto(deletedExercise));
        }

        return Optional.empty();
    }
}
