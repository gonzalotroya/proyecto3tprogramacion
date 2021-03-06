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
INSERT INTO Sectores VALUES(1,"ENERGIA");
create table etf(
valor float,
sectores varchar(100) primary key,
estaComprada boolean
);
INSert into etf VALUES(50,'INDUSTRIA',false);
INSert into etf VALUES(90,'Renovables',false);
INSert into etf VALUES(70,'METALES',false);

Create table Acciones(
acc_id int primary key not null auto_increment,
oper_id int not null,
porcentaje int,
CONSTRAINT oper_id foreign key (oper_id) references operaciones(ope_id)
);


create table empresa(
valor float,
nombre varchar(100),
mercado VARCHAR(100),
estaComprada boolean,
primary key(nombre)
);
INSert into empresa VALUES(2380,'Alphabet','USA',false);
INSert into empresa VALUES(1.16,'sens','USA',false);
INSert into empresa VALUES(200,'Netflix','USA',false);
INSert into empresa VALUES(4.65,'Telefonica','Europa',false);
INSert into empresa VALUES(15.60,'Repsol','Europa',false);
INSert into empresa VALUES(38.90,'CRH','Europa',false);

create table opcion(
calls float,
corto float,
interes float
);
INSERT INTO opcion VALUES(0.37,1,5);

create table noticias(
titular varchar(100) primary key,
cuerpo varchar(900),
fecha Date
);
INSERT INTO noticias VALUES('Subida nice','Los datos son buenos','2022-06-22');
INSERT INTO noticias VALUES('Los mercados estan estables','Apertura estable','2022-06-23');
INSERT INTO noticias VALUES('Ligeras caidas','Suaves caidas','2022-06-24');
INSERT INTO noticias VALUES('Subida ligera','Ligera subida','2022-06-25');
INSERT INTO noticias VALUES('Subida moderada','Subida moderada','2022-06-26');
INSERT INTO noticias VALUES('Gran subida','Auge en los mercados','2022-06-27');