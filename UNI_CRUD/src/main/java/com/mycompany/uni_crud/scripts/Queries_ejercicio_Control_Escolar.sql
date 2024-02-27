/* Para una carrera mostrar sus materias por cada semestre */
SELECT c.nombre carrera, s.nombre semestre, m.nombre materia FROM materias m 
JOIN semestres s ON m.idSemestres = s.id 
JOIN carreras c ON s.idCarreras = c.id;

/*Mostrar el historial académico de un alumno (semestre y materias cursadas) */
SELECT c.nota, a.nombre alumno, s.nombre semestre, m.nombre materia 
FROM calificaciones c 
JOIN alumnos a ON c.idAlumnos = a.id 
JOIN materias m ON c.idMaterias = m.id 
JOIN semestres s ON m.idSemestres = s.id;

# Mostrar las materias de un catedrático
SELECT c.nombre catedratico, m.nombre materia 
FROM materias m 
JOIN catedraticos c ON m.idCatedraticos = c.id;
 
# Mostrar los alumnos de una materia
SELECT a.nombre alumno, m.nombre materia FROM alumnos a 
JOIN cursar c ON c.idAlumnos = a.id 
JOIN materias m ON c.idMaterias = m.id 
WHERE m.nombre LIKE "quimica";

# ¿Cuantos alumnos hay en una materia?
SELECT  count(a.id)  AS 'Cantidad alumnos'
FROM alumnos a JOIN cursar c ON c.idAlumnos = a.id 
JOIN materias m ON c.idMaterias = m.id 
WHERE m.nombre = "quimica";

# Mostrar las notas de un alumno
SELECT a.nombre alumno, c.nota nota 
FROM calificaciones c 
JOIN alumnos a ON c.idAlumnos = a.id 
WHERE a.nombre = "pepe"; 

#Mostrar Notas asignadas por un catedrático
SELECT c.nota nota, m.nombre, cat.nombre FROM calificaciones c 
JOIN materias m ON c.idMaterias = m.id 
JOIN catedraticos cat ON m.idCatedraticos = cat.id 
WHERE cat.nombre LIKE "juan";

#Para una materia mostrar notas > 7 en orden descendiente
SELECT c.nota nota, m.nombre materias 
FROM calificaciones c 
JOIN materias m ON c.idMaterias = m.id 
WHERE m.nombre = "mates" AND (c.nota > 7) 
ORDER BY c.nota DESC;

# ¿Que carrera cursa Ignacio Pérez?
SELECT * 
FROM alumnos a 
JOIN cursar c ON c.idAlumnos = a.id 
JOIN materias m ON c.idMaterias = m.id 
JOIN semestres s ON s.id = m.idSemestres 
JOIN carreras car ON car.id = s.idCarreras
WHERE a.nombre = "pepo";