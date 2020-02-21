DROP TABLE user IF EXISTS;
DROP TABLE article IF EXISTS;

CREATE TABLE user (
    id INTEGER IDENTITY PRIMARY KEY,
    email VARCHAR(125) NOT NULL,
    user_name VARCHAR(125),
    password VARCHAR(255),
    bio VARCHAR(255),
    avatar VARCHAR(255)
);

CREATE TABLE article (
    id INTEGER  IDENTITY PRIMARY KEY,
    slug VARCHAR(125),
    title VARCHAR(255),
    description VARCHAR(255),
    body TEXT,
    created_at DATE,
    updated_at DATE,
    user_id INTEGER NOT NULL
);
ALTER TABLE article ADD CONSTRAINT fk_article_user FOREIGN KEY (user_id) REFERENCES user (id);