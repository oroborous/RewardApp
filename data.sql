DROP TABLE IF EXISTS USER_DB;

CREATE TABLE USER_DB (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  points INT NOT NULL
);

INSERT INTO USER_DB (name, points) VALUES
  ('Eugene', 34),
  ('Bill', 25),
  ('Matthew', 55);


DROP TABLE IF EXISTS LOG_OUTPUT;

CREATE TABLE LOG_OUTPUT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  resource_name VARCHAR(75) NOT NULL,
  error_id VARCHAR(75) NOT NULL,
  description VARCHAR(250) NOT NULL
);

INSERT INTO LOG_OUTPUT (resource_name, error_id, description) VALUES
  ('Cell 1', 'A23456', 'Problem with a server'),
  ('Cell 2', 'B23456', 'Binary output is not correct'),
  ('Cell 3', 'AB23456', 'Execution problem');