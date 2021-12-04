create schema EQDB default character set utf8;
use EQDB;
create table Department(
Dno varchar(5) primary key,
Dname varchar(20) unique,
Dmanager varchar(5) not null);
create table Staff(
Sno varchar(10) primary key,
Spw varchar(20) not null,
Sname varchar(5) not null,
Stel int not null,
Sis_mana boolean not null,
Sdepno varchar(5) not null,
foreign key(Sdepno) references Department(Dno));
create table Equipment(
Eno varchar(5) primary key,
Ename varchar(10) unique,
Espec varchar(10) not null,
Epic blob,
Eprice double(7, 2) not null,
Edate date not null,
Eloc varchar(10) not null,
Emanager varchar(5) not null,
foreign key(Emanager) references staff(Sno));