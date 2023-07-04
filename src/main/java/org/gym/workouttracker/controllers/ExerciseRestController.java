package org.gym.workouttracker.controllers;

import lombok.RequiredArgsConstructor;
import org.gym.workouttracker.models.ExerciseDTO;
import org.gym.workouttracker.services.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseRestController {

    private final ExerciseService exerciseService;

    @PostMapping("/add")
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody @Validated ExerciseDTO exerciseDTO) {
        ExerciseDTO createdDto = exerciseService.createExercise(exerciseDTO);
        return new ResponseEntity<>(
                createdDto,
                HttpStatus.CREATED
                );
    }

    @GetMapping("/list")
    public List<ExerciseDTO> getAllExercises(@RequestBody(required = false) String exerciseName) {
        return exerciseService.getExercises(exerciseName);
    }

    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseDTO> getExerciseById(@PathVariable("exerciseId") UUID exerciseId) {
        return new ResponseEntity<>(
                exerciseService.getExerciseById(exerciseId),
                HttpStatus.FOUND
        );
    }

    @PutMapping("/edit/{exerciseId}")
    public ResponseEntity<ExerciseDTO> updateExercise(@PathVariable("exerciseId") UUID exerciseId,
                                                      @RequestBody @Validated ExerciseDTO exerciseDTO) {
        return new ResponseEntity<>(
                exerciseService.updateExercise(exerciseId, exerciseDTO),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/delete/{exerciseId}")
    public ResponseEntity<ExerciseDTO> deleteExerciseById(@PathVariable("exerciseId") UUID exerciseId) {
        return new ResponseEntity<>(
                exerciseService.deleteExerciseById(exerciseId),
                HttpStatus.ACCEPTED
        );
    }



}
