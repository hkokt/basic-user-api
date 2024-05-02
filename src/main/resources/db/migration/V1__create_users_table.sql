CREATE TABLE users
(
    user_id       SERIAL,
    user_name     VARCHAR(100),
    user_email    VARCHAR(100) UNIQUE,
    user_password VARCHAR(100),
    user_role     VARCHAR(100),
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);