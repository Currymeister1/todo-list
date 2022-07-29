CREATE TABLE tasks(
    id bigint auto_increment PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    started date,
    ended date,
    issuer VARCHAR(255),
    category VARCHAR(255)

);