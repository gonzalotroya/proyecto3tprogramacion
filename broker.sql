DROP DATABASE IF exists broker;

CREATE DATABASE broker;
use broker;

create table usuario(
	nombre varchar(200),
    apellidos VARchar(200),
    email varchar(400),
    contrasena varchar(30),
    fechaNacimiento date,
    numeroAcciones INT,
    saldoInvertido int,
    saldoLibre int,
    cuentaBanco VARCHAR(30),
    dni VARCHAR(10) primary key,
    telefono int
);

create table empresa(
valor int,
nombre varchar(100) primary key,
indice VARCHAR(100)
);

create table etf(
sectores varchar(100) primary key
);
create table noticias(
titular varchar(100) primary key,
cuerpo varchar(900),
fecha Date
);

