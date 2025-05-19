-- Insertar usuarios
INSERT INTO usuarios (id_usuario, nombre, apellido, email) VALUES
(1, 'Juan', 'Garcia', 'jaugar@gmail.com'),
(2, 'Felipe', 'Soris', 'felso@gmail.com'),
(3, 'Carlos', 'Fortea', 'carfo@gmail.com'),
(4, 'Luis', 'Gair', 'lugar@gmail.com');

-- Insertar proyectos
INSERT INTO proyectos (id_proyecto, nombre, descripcion, id_usuario) VALUES
(1, 'Proyecto web', 'Desarrollo de un espacio web', 1),
(2, 'App Tiempo', 'Desarrollo aplicación para ver el tiempo', 2),
(3, 'App Movil', 'App para planificar tareas diarias', 3),
(4, 'Juego Movil', 'Juego para móvil', 4);

-- Insertar tareas
INSERT INTO tareas (id_tarea, titulo, id_proyecto, id_usuario, estado) VALUES
(1, 'Preparación de entorno', 1, 1, 'PENDIENTE'),
(2, 'Creación paquetes', 1, 1, 'EN PROCESO'),
(3, 'Conexión base de datos', 1, 1, 'COMPLETADO'),
(4, 'Probar aplicación', 1, 1, 'PENDIENTE');

