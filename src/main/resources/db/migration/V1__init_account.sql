create table account
(
    uid        varchar(255) primary key,
    login      varchar(30) unique not null,
    password   varchar(80)        not null,
    email      varchar(50) unique not null,
    phone      varchar(11) unique not null,
    firstname  varchar(30)        not null,
    surname    varchar(30)        not null,
    active     boolean            not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);