ALTER TABLE cars ALTER_COLUMN insurance_id TYPE BIGINT;
ALTER TABLE customers ALTER_COLUMN car_id TYPE BIGINT;
ALTER TABLE cars ADD CONSTRAINT car_pk PRIMARY KEY (id);