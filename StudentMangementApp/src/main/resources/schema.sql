CREATE TABLE student (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_of_birth DATE,
    gender VARCHAR(10),
    email_address VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255),
    primary key (id)
);
