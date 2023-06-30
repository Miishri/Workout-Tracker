package org.gym.workouttracker.controllers;

import lombok.RequiredArgsConstructor;
import org.gym.workouttracker.services.ExerciseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseRestController {
    private final ExerciseService exerciseService;
}
