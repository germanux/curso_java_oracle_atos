/* Funciones */

CREATE OR REPLACE FUNCTION ANIO_NACIMIENTO (edad NUMBER)
	RETURN NUMBER
IS
	resultado NUMBER;
BEGIN
	resultado := extract(YEAR FROM SYSDATE) - edad;
	
	return resultado;
END;

SELECT nombre, edad, ANIO_NACIMIENTO(edad) FROM usuario;

CREATE OR REPLACE FUNCTION NOTA_CAD (nota NUMBER)
	RETURN VARCHAR2
IS resultado VARCHAR2(15);
BEGIN
	IF nota < 5 THEN
		resultado:= 'Suspenso';
	ELSIF nota < 6 THEN
		resultado := 'Suficiente';
	ELSIF nota < 8 THEN
		resultado := 'Notable';
	ELSE  resultado := 'De puta madre';
	END IF;
	
	return resultado;
END;

SELECT Nombre, nota, NOTA_CAD(nota) AS nota_cad from usuario;

/* www.tutorialesprogramacionya.com/oracleya */


CREATE PROCEDURE CUMPLIR_ANIOS 
	AS BEGIN
		UPDATE USUARIO SET edad = edad + 1;
	END;

EXECUTE CUMPLIR_ANIOS;

ALTER table departamento ADD aprobados NUMBER(2,0);
/* No compila por las variable */
CREATE  PROCEDURE Rellenar_aprobados
IS
	CURSOR CUR IS 	SELECT ID FROM departamento;
	/*CURSOR cur2 is SELECT COUNT(U.ID) FROM DEPARTAMENTO D
			JOIN USU_DEPT UD ON UD.ID_DEPT = D.ID
			JOIN USUARIO U ON U.ID = UD.ID_USU
			WHERE u.nota > 5 AND D.ID = id_D;*/
	ID_D NUMBER(2,0);
	SUMA NUMBER(2,0);
BEGIN
	OPEN CUR;
	FETCH CUR INTO ID_D;
	WHILE CUR%FOUND LOOP
		SELECT COUNT(U.ID) into SUMA FROM DEPARTAMENTO D
			JOIN USU_DEPT UD ON UD.ID_DEPT = D.ID
			JOIN USUARIO U ON U.ID = UD.ID_USU
			WHERE u.nota > 5 AND D.ID = :id_D
		UPDATE departamento SET aprobados = :SUMA WHERE
			id= :ID_D;
		FETCH CUR INTO ID_D;
	END LOOP;
	
	CLOSE CUR;
END;




