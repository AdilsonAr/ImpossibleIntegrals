create database ImpossibleIntegrals;
use ImpossibleIntegrals;

create table integrals(
className varchar(15) primary key,
decription varchar(50) not null
);

create table users(
id int primary key auto_increment,
userNickname varchar(15) not null,
userName varchar(50) not null,
e_mail varchar(50),
pass varchar(32) not null
);

select*from integrals;
select*from users;