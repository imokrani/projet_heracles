create database heracles_atelier character set UTF8; 
use heracles_atelier; 
-- On
drop table if exists atelier; 
create table atelier 
(
    idatelier smallint not null auto_increment, 
    nom varchar(30), 
    description varchar(255),
    objectif text,
    dtcreation datetime,
    dtmaj datetime,
    primary key (idatelier)
);