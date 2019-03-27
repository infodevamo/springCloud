drop table DOCUMENT if exists;

create table DOCUMENT (ID bigint identity primary key, NAME varchar(255) not null,
                        owner varchar(255) not null, content_type varchar(255) not null, uploaded_date timestamp, unique(NAME));
                       
create sequence hibernate_sequence;
