


-- Crear la tabla Videojuegos
CREATE TABLE IF NOT EXISTS Videojuegos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50),
    anio_lanzamiento INT NOT NULL,
    precio DECIMAL(10, 2),
    fecha_actualizacion DATE,
    disponible BOOLEAN);

-- Poblar la tabla con algunos datos
INSERT INTO Videojuegos (titulo, plataforma, anio_lanzamiento, precio, fecha_actualizacion, disponible) VALUES
    ('The Legend of Zelda', 'Nintendo Switch', 2017, 59.99, '2023-01-15', TRUE),
    ('Minecraft', 'PC', 2011, 26.95, NULL, TRUE),
    ('Cyberpunk 2077', 'PlayStation 5', 2020, 49.99, '2023-06-10', FALSE),
    ('Elden Ring', NULL, 2022, NULL, '2023-09-05', TRUE),
    ('Among Us', 'Mobile', 2018, 5.00, NULL, NULL);
