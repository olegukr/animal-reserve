-- Insert countries
INSERT INTO country (id, country_name) VALUES
(1, 'Kenya'),
(2, 'India'),
(3, 'Brazil'),
(4, 'Australia'),
(5, 'Canada');

-- Insert genders
INSERT INTO gender (id, gender_name) VALUES
(1, 'Male'),
(2, 'Female');

-- Insert families
INSERT INTO animal_family (id, family_name) VALUES
(1, 'Felidae'),
(2, 'Canids'),
(3, 'Reptiles'),
(4, 'Mustelids'),
(5, 'Leporidae');

-- Insert types for Felidae
INSERT INTO animal_type (id, type_name) VALUES
(1, 'Lion'),
(2, 'Tiger'),
(3, 'Leopard'),
(4, 'Cheetah'),
(5, 'Panther'),
(6, 'Cougar'),
(7, 'Caracal');

-- Insert types for Canids
INSERT INTO animal_type (id, type_name) VALUES
(8, 'Fox'),
(9, 'Wolf'),
(10, 'Jackal'),
(11, 'Dingo'),
(12, 'Coyote'),
(13, 'Raccoon Dog'),
(14, 'Maned Wolf');

-- Insert types for Reptiles
INSERT INTO animal_type (id, type_name) VALUES
(15, 'Crocodile'),
(16, 'Snake'),
(17, 'Iguana'),
(18, 'Turtle'),
(19, 'Chameleon'),
(20, 'Gecko'),
(21, 'Alligator');

-- Insert types for Mustelids
INSERT INTO animal_type (id, type_name) VALUES
(22, 'Otter'),
(23, 'Weasel'),
(24, 'Badger'),
(25, 'Marten'),
(26, 'Ferret'),
(27, 'Polecat'),
(28, 'Mink');

-- Insert types for Leporidae
INSERT INTO animal_type (id, type_name) VALUES
(29, 'Rabbit'),
(30, 'Hare'),
(31, 'Cottontail'),
(32, 'Pika'),
(33, 'Jackrabbit'),
(34, 'Snowshoe Hare'),
(35, 'Volcano Rabbit');

-- Insert animals for Felidae
INSERT INTO animal (name, type_id, family_id, gender_id, country_id, date_of_entry, image) VALUES
('Leo', 1, 1, 1, 1, '2025-01-01', NULL),
('Shere Khan', 2, 1, 1, 1, '2025-01-02', NULL),
('Bagheera', 3, 1, 2, 2, '2025-01-03', NULL),
('Simba', 1, 1, 1, 3, '2025-01-04', NULL),
('Nala', 1, 1, 2, 3, '2025-01-05', NULL),
('Spotty', 4, 1, 2, 4, '2025-01-06', NULL),
('Shadow', 5, 1, 1, 5, '2025-01-07', NULL);

-- Insert animals for Canids
INSERT INTO animal (name, type_id, family_id, gender_id, country_id, date_of_entry, image) VALUES
('Foxy', 8, 2, 2, 1, '2025-01-01', NULL),
('White Fang', 9, 2, 1, 2, '2025-01-02', NULL),
('Jack', 10, 2, 1, 3, '2025-01-03', NULL),
('Dingo', 11, 2, 2, 4, '2025-01-04', NULL),
('Coyote', 12, 2, 1, 5, '2025-01-05', NULL),
('Rocco', 13, 2, 1, 1, '2025-01-06', NULL),
('Manny', 14, 2, 2, 2, '2025-01-07', NULL);

-- Insert animals for Reptiles
INSERT INTO animal (name, type_id, family_id, gender_id, country_id, date_of_entry, image) VALUES
('Croc', 15, 3, 1, 3, '2025-01-01', NULL),  
('Slither', 16, 3, 2, 4, '2025-01-02', NULL),
('Iggy', 17, 3, 2, 5, '2025-01-03', NULL),
('Turt', 18, 3, 1, 1, '2025-01-04', NULL),
('Chamy', 19, 3, 2, 2, '2025-01-05', NULL),
('Gex', 20, 3, 1, 3, '2025-01-06', NULL),
('Ali', 21, 3, 1, 4, '2025-01-07', NULL);

-- Insert animals for Mustelids
INSERT INTO animal (name, type_id, family_id, gender_id, country_id, date_of_entry, image) VALUES
('Otto', 22, 4, 1, 5, '2025-01-01', NULL),
('Weasel', 23, 4, 2, 1, '2025-01-02', NULL),
('Badger', 24, 4, 1, 2, '2025-01-03', NULL),
('Martin', 25, 4, 2, 3, '2025-01-04', NULL),
('Ferry', 26, 4, 2, 4, '2025-01-05', NULL),
('Poley', 27, 4, 1, 5, '2025-01-06', NULL),
('Mink', 28, 4, 2, 1, '2025-01-07', NULL);

-- Insert animals for Leporidae
INSERT INTO animal (name, type_id, family_id, gender_id, country_id, date_of_entry, image) VALUES
('Bunny', 29, 5, 1, 2, '2025-01-01', NULL),
('Hopper', 30, 5, 2, 3, '2025-01-02', NULL),
('Cotton', 31, 5, 1, 4, '2025-01-03', NULL),
('Pika', 32, 5, 2, 5, '2025-01-04', NULL),
('Jacky', 33, 5, 1, 1, '2025-01-05', NULL),
('Snow', 34, 5, 2, 2, '2025-01-06', NULL),
('Volcano', 35, 5, 1, 3, '2025-01-07', NULL);

/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'user', '$2a$10$kwmIdIgrS3XwUJXMaSfV4O92wLSV5WeMfMeg/ZmeVzdyW72xhNU7.');
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$10$eUmWt/7ars7RgXhhmoEmOuUwOxnzmAI7pJY10qvjlCrCrKSH');

/* Roles Users */
INSERT INTO roles_users (id_user, id_role) VALUES (1, 1);
INSERT INTO roles_users (id_user, id_role) VALUES (2, 2);

