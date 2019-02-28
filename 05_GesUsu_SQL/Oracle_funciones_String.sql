
DROP TRIGGER a_dept_bir;
DROP TABLE USUARIO;  /*  Elimina la tabla completa*/
/* Comandos borrar SÓLO registros*/
TRUNCATE TABLE USUARIO;
DELETE TABLE USUARIO;	/* Copia de seguridad datos, es más lento */
	
UPDATE USUARIO SET edad = edad + 1;
SELECT * FROM USUARIO;
SELECT * FROM USUARIO WHERE edad >= 20 AND edad < 30;
/* COncatenación SQL */
SELECT nombre||': <'||email||'> tiene '||edad||' años'
	AS texto_formateado FROM USUARIO;
/* Campos calculados */
SELECT nombre, 2018 - edad AS anio_nacim FROM USUARIO;

SELECT 'Hola, muy buenas' AS texto FROM dual;	-- Texto tal cual
SELECT upper('Hola, muy buenas') AS texto FROM dual;	-- Texto tal
SELECT lower('Hola, muy buenas') AS texto FROM dual;	-- Texto tal cual
SELECT initcap(nombre) AS Nombre_Cap FROM USUARIO;

SELECT NOMBRE, EDAD FROM USUARIO WHERE EDAD NOT BETWEEN 20 AND 30;

SELECT NOMBRE, APELLIDOS FROM USUARIO WHERE APELLIDOS IS NULL;
/* Quitando espacios Derecha, izq y ambos lados */
SELECT RTRIM(DESCRIPCION) FROM USUARIO;
SELECT LTRIM(DESCRIPCION) FROM USUARIO;
SELECT TRIM(DESCRIPCION) FROM USUARIO;

SELECT REPLACE(DESCRIPCION, 'todos', 'cualquiera') FROM USUARIO;
SELECT TRIM(BOTH '*' FROM REPLACE(DESCRIPCION, 'todos', 'cualquiera')) FROM USUARIO;

SELECT SUBSTR(DESCRIPCION, 3, 5), LENGTH(DESCRIPCION) FROM USUARIO;
SELECT INSTR(descripcion, 'vago') FROM USUARIO;
SELECT TRANSLATE(descripcion, 'aeiou', '43102') FROM USUARIO;




