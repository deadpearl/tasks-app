CREATE TABLE _users (
                      id BIGSERIAL PRIMARY KEY,
                      login varchar(255),
                      password varchar(255)
                    );

CREATE INDEX _users_login_idx ON task (login);

