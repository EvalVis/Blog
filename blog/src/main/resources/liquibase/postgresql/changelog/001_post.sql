CREATE TABLE IF NOT EXISTS post (
    id VARCHAR(255) PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL
);