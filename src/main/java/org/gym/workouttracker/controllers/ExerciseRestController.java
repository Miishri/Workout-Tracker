package org.gym.workouttracker.controllers;

import lombok.RequiredArgsConstructor;
import org.gym.workouttracker.models.ExerciseDTO;
import org.gym.workouttracker.repositories.ExerciseRepository;
import org.gym.workouttracker.services.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseRestController {
    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;

    @PostMapping("/add")
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody @Validated ExerciseDTO exerciseDTO) {
        ExerciseDTO createdDto = exerciseService.createExercise(exerciseDTO);
        return new ResponseEntity<>(
                createdDto,
                HttpStatus.CREATED
                );
    }
}
