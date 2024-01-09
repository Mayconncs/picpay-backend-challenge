CREATE TABLE transaction (
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,
    value DECIMAL(13,2) NOT NULL,
    payer_id BIGINT NOT NULL,
    payee_id BIGINT NOT NULL,
    time_stamp TIMESTAMP
);