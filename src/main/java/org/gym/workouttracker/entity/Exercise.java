package org.gym.workouttracker.entity;

import jakarta.persistence.*;


@Entity
public class Exercise {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "column_id", nullable = false)
    private Long id;

    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;

    @Column(name = "exercise_note", nullable = false, length = 100)
    private String exerciseNote;

    @Column(name = "recent_sets")
    private Integer recentExerciseSets;

}
