package org.gym.workouttracker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gym.workouttracker.entities.Exercise;
import org.gym.workouttracker.mappers.ExerciseMapper;
import org.gym.workouttracker.models.ExerciseDTO;
import org.gym.workouttracker.repositories.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExerciseRestControllerTest {

    @Autowired
    ExerciseRestController exerciseRestController;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseMapper exerciseMapper;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();

    }

    @Test
    @Transactional
    @Rollback
    void testCreateExercise() {
        ExerciseDTO exerciseDTO = ExerciseDTO.builder()
                .exerciseName("Test Exercise")
                .build();

        ResponseEntity<ExerciseDTO> responseEntity = exerciseRestController.createExercise(exerciseDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getExerciseName()).isEqualTo(exerciseDTO.getExerciseName());
    }

    @Test
    void getAllExercises() {
        List<ExerciseDTO> exerciseList = exerciseRestController.getAllExercises(null);

        assertThat(exerciseList.size()).isEqualTo(5);
    }

    @Test
    void getAllExercisesByExerciseName() {
        List<ExerciseDTO> exerciseList = exerciseRestController.getAllExercises("Squat");

        assertThat(exerciseList.size()).isEqualTo(1);
    }

    @Test
    void getExerciseById() {
        Exercise exercise = exerciseRepository.findAll().get(0);

        ResponseEntity<ExerciseDTO> responseEntity = exerciseRestController.getExerciseById(exercise.getId());

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(302));
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getId()).isEqualTo(exercise.getId());
    }

    @Test
    @Rollback
    @Transactional
    void updateExercise() {

        Exercise exercise = exerciseRepository.findAll().get(0);
        ExerciseDTO exerciseDTO = exerciseMapper.ExerciseToExerciseDto(exercise);
        exerciseDTO.setExerciseName("Updated Exercise");
        exerciseDTO.setExerciseDetails("This is an updated version");
        exerciseDTO.setRecentExerciseSets(1);
        exerciseDTO.setExercisePersonalRecord(new BigDecimal("199"));

        ResponseEntity<ExerciseDTO> responseEntity = exerciseRestController.updateExercise(exercise.getId(), exerciseDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(202));

        Exercise updatedExercise = exerciseRepository.findById(exercise.getId()).get();
        assertThat(updatedExercise.getExerciseName()).isEqualTo(exercise.getExerciseName());
    }

    @Test
    @Rollback
    @Transactional
    void deleteExerciseById() {
        Exercise exercise = exerciseRepository.findAll().get(0);

        ResponseEntity<ExerciseDTO> responseEntity = exerciseRestController.deleteExerciseById(exercise.getId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(202));

        assertThat(exerciseRepository.findById(exercise.getId())).isEmpty();
    }
}