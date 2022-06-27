DROP TABLE IF EXISTS player_information;
DROP TABLE IF EXISTS transaction_information;

CREATE TABLE player_information
(
    id INT NOT NULL,
    username VARCHAR(50) NOT NULL,
    balance NUMERIC(19,2) NOT NULL,
    created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE transaction_information
(
    id INT NOT NULL,
    amount NUMERIC(19,2),
    transaction_type VARCHAR(50),
    player_information_id INT NOT NULL,
    created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE INDEX idx_player_information
    ON player_information(id, username);

CREATE INDEX idx_transaction_information
    ON transaction_information(id);

CREATE SEQUENCE id_seq
  START WITH 1
  INCREMENT BY 1;