package org.gym.workouttracker.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Exercises")
public class Exercise {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Id
    @Column(name = "exercise_id", nullable = false, updatable = false, columnDefinition = "char(36)")
    private UUID id;

    @Column(name = "exercise_name", nullable = false, length = 100)
    private String exerciseName;

    @Column(name = "exercise_details", nullable = false, length = 150)
    private String exerciseDetails;

    @Column(name = "recent_exercise_sets")
    private Integer recentExerciseSets;

    @CreationTimestamp
    @Column(name = "exercise_created")
    private LocalDateTime exerciseCreationDate;
}
