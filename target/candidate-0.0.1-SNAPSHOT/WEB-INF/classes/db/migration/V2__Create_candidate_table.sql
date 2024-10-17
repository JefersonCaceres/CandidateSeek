CREATE TABLE candidate (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    gender CHAR(1) NOT NULL,
    salary_expected DOUBLE,
    phone VARCHAR(255),
    status_id INT,
    created_at DATE,
    updated_at DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (status_id) REFERENCES status(id)
);

