package org.gym.workouttracker.Bootstrap;

import lombok.RequiredArgsConstructor;
import org.gym.workouttracker.entities.Exercise;
import org.gym.workouttracker.repositories.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ExerciseBootstrap implements CommandLineRunner {

    private  final ExerciseRepository exerciseRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        loadExercises();
    }

    private void loadExercises() {

        if (exerciseRepository.findAll().size() < 5) {
            Exercise exerciseOne = Exercise.builder()
                    .exerciseName("Bench Press")
                    .exerciseDetails("Pump your chests")
                    .recentExerciseSets(4)
                    .build();
            Exercise exerciseTwo = Exercise.builder()
                    .exerciseName("Squat")
                    .exerciseDetails("Get thighs to the sky")
                    .recentExerciseSets(2)
                    .build();
            Exercise exerciseThree = Exercise.builder()
                    .exerciseName("Deadlift")
                    .exerciseDetails("Back needs a crack")
                    .recentExerciseSets(5)
                    .build();
            Exercise exerciseFour = Exercise.builder()
                    .exerciseName("Rope-Pulldown")
                    .exerciseDetails("Pull it all the way down")
                    .recentExerciseSets(3)
                    .build();
            Exercise exerciseFive = Exercise.builder()
                    .exerciseName("Cycling")
                    .exerciseDetails("Cycle Cycle Cycle")
                    .recentExerciseSets(6)
                    .build();

            exerciseRepository.saveAll(Arrays.asList(exerciseOne,
                    exerciseTwo,
                    exerciseThree,
                    exerciseFour,
                    exerciseFive));
        }

    }
}
