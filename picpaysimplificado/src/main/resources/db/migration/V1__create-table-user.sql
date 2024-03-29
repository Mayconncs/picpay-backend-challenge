CREATE TABLE users (
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    identity VARCHAR(25) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(80) NOT NULL,
    user_type VARCHAR(10) NOT NULL,
    balance DECIMAL(13,2) NOT NULL 
);
