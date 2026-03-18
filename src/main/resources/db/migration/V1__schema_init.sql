CREATE TABLE stations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL
);

CREATE TABLE trains (
    id BIGSERIAL PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
);

CREATE TABLE routes (
    id BIGSERIAL PRIMARY KEY,
    train_id BIGINT REFERENCES trains(id) NOT NULL,
    departure_station_id BIGINT REFERENCES stations(id) NOT NULL,
    arrival_station_id BIGINT REFERENCES stations(id) NOT NULL,
    departure_time TIMESTAMPTZ NOT NULL,
    arrival_time TIMESTAMPTZ NOT NULL,
    price DECIMAL(10, 2) NOT NULL
)