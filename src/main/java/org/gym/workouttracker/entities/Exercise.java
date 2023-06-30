package org.gym.workouttracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Exercise name is required")
    private String exerciseName;

    @Column(name = "exercise_details", nullable = false, length = 150)
    @Size(max = 150)
    private String exerciseDetails;

    @Column(name = "recent_sets")
    @Max(20)
    private Integer recentExerciseSets;

    @CreationTimestamp
    private LocalDateTime exerciseCreationDate;
}
