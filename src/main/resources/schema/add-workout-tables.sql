

CREATE TABLE exercises (
    exercise_id 			char(36) 		 NOT NULL,
    exercise_name 			varchar(100) 	 NOT NULL,
    exercise_details 		varchar(150)	 NOT NULL,
    recent_exercise_sets	int 			 DEFAULT 0,
    exercise_created		datetime(6) 	 NOT NULL,
    PRIMARY KEY             (exercise_id)
)