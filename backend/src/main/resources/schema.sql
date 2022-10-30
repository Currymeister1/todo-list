CREATE TABLE IF NOT EXISTS roles(
                                    id bigint auto_increment PRIMARY KEY,
                                    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS issuers(
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255),
        groupId bigint,
        FOREIGN KEY (groupId) REFERENCES roles(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS tasks(
    id bigint auto_increment PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    started date,
    ended date,
    issuer VARCHAR(255),
    category VARCHAR(255),
    groupID bigint,
    FOREIGN KEY (issuer) REFERENCES issuers(id) ON DELETE SET NULL,
    FOREIGN KEY (groupID) REFERENCES roles(id) ON DELETE SET NULL
);



