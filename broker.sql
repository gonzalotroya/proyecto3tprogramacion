/*DROP DATABASE IF exists broker;*/

CREATE DATABASE broker;
use broker;

create table usuario(
	id int primary key,
	nombre varchar(200),
    email varchar(400),
    contrasena varchar(30),
    fechaNacimiento date,
    numeroAcciones INT,
    saldo int,
    cuentaBanco VARCHAR(30),
    dni VARCHAR(10),
    telefono int
);

create table empresa(
id int primary key,
valor int,
nombre varchar(100),
indice VARCHAR(100)
);

create table etf(
id int primary key,
sectores varchar(100)
);
create table noticias(
id int primary key,
noticias varchar(900),
fecha Date
);

