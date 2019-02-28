UPDATE usuario 
	SET fecha_registro = 
		add_months(fecha_registro, 
				-1 + ROUND(dbms_random.value(1, 11)));
					
UPDATE usuario 
		SET fecha_registro =  fecha_registro - 27 
					+ ROUND(dbms_random.value(1, 20));

SELECT Nombre, fecha_registro FROM usuario WHERE 
	fecha_registro BETWEEN '1/1/2019' AND '1/4/2019';

SELECT Nombre, fecha_registro, NEXT_DAY(fecha_registro, 'LUNES')
	FROM usuario;

SELECT current_date FROM dual;
SELECT current_timestamp FROM dual;
SELECT SYSDATE FROM dual;
SELECT SYSTIMESTAMP FROM dual;

SELECT TO_DATE('05-SEP-2018 10:33 AM', 'DD-MON-YYYY HH:MI AM') 
	FROM dual;

SELECT fecha_registro, to_char(fecha_registro) FROM usuario;








