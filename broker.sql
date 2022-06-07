DROP DATABASE IF exists broker;

CREATE DATABASE broker;
use broker;

create table usuario(
	nombre varchar(200),
    apellidos VARchar(200),
    email varchar(400),
    contrasena varchar(30),
    fechaNacimiento date,
    saldoInvertido int,
    saldoLibre int,
    cuentaBanco VARCHAR(30),
    dni VARCHAR(10) primary key,
    telefono int
);
create table tipo_operacion(
tipo_id int primary key not null auto_increment,
nombre varchar (40) 
);
INSert into tipo_operacion VALUES(1,'Comprar');
INSERT INTO tipo_operacion VALUES(2,'Vender');
Create table operaciones(
ope_id int primary key not null auto_increment,
tipo_id int,
CONSTRAINT tipo_id foreign key (tipo_id) references tipo_operacion(tipo_id) 
);

create table Sectores(
sec_id int primary key not null auto_increment,
nombreSector varchar (200)
);
create table etf(
etf_id int primary key not null auto_increment,
Ope_id int not null,
CONSTRAINT ope_id foreign key (ope_id) references operaciones(ope_id),
sec_id int not null,
CONSTRAINT sec_id foreign key (sec_id) references operaciones(ope_id) 
);

Create table Acciones(
acc_id int primary key not null auto_increment,
oper_id int not null,
porcentaje int,
CONSTRAINT oper_id foreign key (oper_id) references operaciones(ope_id)
);


create table empresa(
valor float,
nombre varchar(100) primary key,
mercado VARCHAR(100)
);
INSert into empresa VALUES(2380,'Alphabet','USA');
INSert into empresa VALUES(1.16,'sens','USA');
INSert into empresa VALUES(200,'Netflix','USA');
INSert into empresa VALUES(4.65,'Telefonica','Europa');
INSert into empresa VALUES(15.60,'Repsol','Europa');
INSert into empresa VALUES(38.90,'CRH','Europa');

create table opcion(
calls int,
corto int,
interes int
);

create table noticias(
titular varchar(100) primary key,
cuerpo varchar(900),
fecha Date
);

