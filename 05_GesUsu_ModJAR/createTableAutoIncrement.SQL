create table "ROOT".USUARIOS
(
    ID INT not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
    NOMBRE VARCHAR(50) not null,
    EDAD INTEGER not null,
    EMAIL VARCHAR(50) unique,
    PASS VARCHAR(50) not null,
    primary key (ID)
)