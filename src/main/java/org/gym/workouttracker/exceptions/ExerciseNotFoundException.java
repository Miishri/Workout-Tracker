package org.gym.workouttracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Exercise was not found")
public class ExerciseNotFoundException extends RuntimeException{

    public ExerciseNotFoundException() {
        super();
    }

    public ExerciseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ExerciseNotFoundException(String message) {
        super(message);
    }
    public ExerciseNotFoundException(Throwable cause) {
        super(cause);
    }

}
