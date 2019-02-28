CREATE TABLE USUARIO (
	ID 		NUMBER(10) NOT NULL,
	NOMBRE VARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(255) NOT NULL,
	EDAD NUMBER(3,0) NOT NULL,
	PASSWORD VARCHAR2(50) NOT NULL
);
ALTER TABLE USUARIO ADD(
	CONSTRAINT a_dept_pk PRIMARY KEY(ID)
);
ALTER TABLE USUARIO ADD 
	CONSTRAINT a_uq_usuario_email UNIQUE(EMAIL);

CREATE SEQUENCE a_dept_seq START WITH 1;

CREATE OR REPLACE TRIGGER a_dept_bir
	BEFORE INSERT ON USUARIO
	FOR EACH ROW	
	BEGIN
		SELECT a_dept_seq.NEXTVAL
		INTO :new.id
		FROM dual;
	END;

INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Aaaaaa', 'aa@aa.com', 25, 'aa');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Bbbbbb', 'bb@bb.com', 35, 'bb');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Cccccc', 'cc@cc.com', 45, 'cc');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Aaa 2 Aaaa', 'aa@aa2.com', 24, 'aa');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Bbb Bbbb 2', 'bb@bb2.com', 32, 'bb');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Cccc Ccc2', 'cc@cc2.com', 40, 'cc');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Aaa3 Aaaa', 'aa@aa3.com', 22, 'aa');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Bbb Bbbb 3', 'bb@bb3.com', 33, 'bb');
INSERT INTO USUARIO (nombre, email, edad, password) 
	VALUES('Cccc Ccc3', 'cc@cc3.com', 44, 'cc');
	
ALTER TABLE USUARIO ADD apellidos VARCHAR2(50);
ALTER TABLE USUARIO ADD fecha_registro DATE;
ALTER TABLE USUARIO ADD descripcion VARCHAR2(100) DEFAULT 'Un vago como todos';

ALTER TABLE USUARIO DROP COLUMN fecha_registro;
ALTER TABLE USUARIO ADD fecha_registro DATE DEFAULT SYSDATE;





