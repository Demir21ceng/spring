CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    duty VARCHAR(255) UNIQUE NOT NULL,
    date DATE NOT NULL DEFAULT CURRENT_DATE,
    importance VARCHAR(20) NOT NULL,
    completion_status VARCHAR(20) NOT NULL
);

CREATE TABLE details (
    id SERIAL PRIMARY KEY,
    details_title VARCHAR(255),
    todo_id INTEGER NOT NULL,
    FOREIGN KEY (todo_id) REFERENCES todos(id) ON DELETE CASCADE
);

