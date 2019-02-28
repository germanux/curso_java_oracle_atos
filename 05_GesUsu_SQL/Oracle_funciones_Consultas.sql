SELECT Nombre, edad, fecha_registro 
	FROM USUARIO ORDER BY fecha_registro;
	
SELECT Nombre, edad, fecha_registro
	FROM USUARIO ORDER BY edad DESC;
	
SELECT Nombre, edad, fecha_registro
	FROM USUARIO ORDER BY Nombre;

SELECT Nombre, edad, fecha_registro 
	FROM USUARIO WHERE edad < 35 and fecha_registro < '10/10/19';
	
DESCRIBE usuario;
/* Contar número regisgtros */
SELECT count(*) AS total FROM USUARIO;
SELECT count(Apellidos) FROM usuario;

SELECT SUM(nota) from usuario;
SELECT AVG(nota) from usuario;
SELECT MAX(nota) from usuario;

SELECT Nombre FROM usuario WHERE nombre LIKE '%aa%';
SELECT count(Nombre) FROM usuario WHERE nombre LIKE '%aa%';

SELECT edad, count(*) FROM usuario GROUP BY edad;

/* Que devuelva el usuario con menor nota de los aprobados */

SELECT min(nota) FROM usuario WHERE nota >= 5;
SELECT * FROM usuario 
	WHERE nota = (SELECT min(nota) FROM usuario WHERE nota >= 5);
	
SELECT * FROM usuario WHERE ROWNUM <= 5;
/* Que nos devuelva la diferencia con respecto a la media de
	los usuarios suspendido */






