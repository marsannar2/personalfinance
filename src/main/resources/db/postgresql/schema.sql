


CREATE TABLE IF NOT EXISTS appusers (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email varchar(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS accounts (
    id SERIAL PRIMARY KEY,
    quantity DOUBLE PRECISION NOT NULL,
    account_type VARCHAR(55) NOT NULL, 
    connection VARCHAR(255),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES appusers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS categories (
    id SERIAL PRIMARY KEY,
    category VARCHAR(255) NOT NULL UNIQUE,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES appusers(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS expenses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    assigned DOUBLE PRECISION NOT NULL,
    target DOUBLE PRECISION NOT NULL,
    target_is_reached BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES appusers(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS transactions (
    id SERIAL PRIMARY KEY,
    amount DOUBLE PRECISION NOT NULL,
    money_flow VARCHAR(55) NOT NULL,
    description VARCHAR(128) NOT NULL,
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);
