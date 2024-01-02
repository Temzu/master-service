create table account
(
    uid        varchar(255) primary key,
    phone      varchar(11) unique not null,
    password   varchar(80)        not null,
    active     boolean            not null,
    email      varchar(50) unique,
    firstname  varchar(30),
    surname    varchar(30),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table role
(
    uid        varchar(255) primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE account_role
(
    user_uid varchar(255) not null references account (uid),
    role_uid varchar(255) not null references role (uid),
    primary key (user_uid, role_uid)
);