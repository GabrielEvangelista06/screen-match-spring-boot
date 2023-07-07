create table movies(
    id bigint not null auto_increment,
    name varchar(100) not null,
    duration_in_minutes int not null,
    release_year int not null,
    category varchar(100),
    primary key(id)
);
