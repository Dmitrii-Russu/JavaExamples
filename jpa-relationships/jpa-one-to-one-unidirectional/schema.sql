CREATE TABLE credential (
    id BIGSERIAL PRIMARY KEY,
    password TEXT NOT NULL
);

CREATE TABLE customer (
    credential_id BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    FOREIGN KEY (credential_id) REFERENCES credential(id)
);
