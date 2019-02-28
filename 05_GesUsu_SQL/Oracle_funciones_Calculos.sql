SELECT dbms_random.value(1, 100) FROM dual;
SELECT ROUND(dbms_random.value(1, 100)) FROM dual;

ALTER TABLE usuario ADD nota NUMBER(4,2) DEFAULT 0;
UPDATE usuario SET nota=dbms_random.value(1, 10);

SELECT NOTA, CEIL(NOTA), FLOOR(NOTA), ROUND(NOTA, 1) FROM USUARIO;

SELECT ABS(-20), MOD(10, 3), POWER(2, 3) FROM dual;
SELECT SIGN(5), SIGN(-3), SQRT(16) FROM dual;

