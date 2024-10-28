--liquibase formatted sql

--changeset nvoxland:1
CREATE TABLE company_valid_check (
                       id serial primary key,
                       check_result boolean not null,
                       check_time time not null,
                       inn varchar(255) not null ,
                       capital numeric not null,
                       region integer not null
);
--rollback drop table company_valid_check;