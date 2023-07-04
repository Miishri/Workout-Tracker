package org.gym.workouttracker.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
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

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "exercise_id", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "exercise_name", nullable = false, length = 100)
    private String exerciseName;

    @Column(name = "exercise_details", nullable = false, length = 150)
    private String exerciseDetails;

    @Column(name = "recent_exercise_sets")
    private Integer recentExerciseSets;

    @Column(name = "personal_record")
    private BigDecimal exercisePersonalRecord;

    @CreationTimestamp
    @Column(name = "exercise_created")
    private LocalDateTime exerciseCreationDate;


}
