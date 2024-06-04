create table if not exists subscription
(
    id                  varchar(255) default gen_random_uuid() primary key,
    name                varchar(255) not null,
    level  integer not null
);

create table if not exists users
(
    id                  varchar(255) default gen_random_uuid() primary key,
    name                varchar(255) not null,
    email               varchar(255) not null,
    subscription_id     varchar(255) not null,
    date_registered     timestamp without time zone default current_timestamp
);

create table if not exists trainings
(
    id                  uuid default gen_random_uuid() primary key,
    name                varchar(255) not null,
    type                varchar(255) not null,
    subscription_level  integer not null,
    training_date       timestamp without time zone default current_timestamp
);
